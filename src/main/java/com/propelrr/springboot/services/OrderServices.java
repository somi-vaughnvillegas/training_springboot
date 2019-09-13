package com.propelrr.springboot.services;

import com.propelrr.springboot.models.*;
import com.propelrr.springboot.repositories.InventoryRepository;
import com.propelrr.springboot.repositories.ItemsRepository;
import com.propelrr.springboot.repositories.OrdersRepository;
import com.propelrr.springboot.validators.CustomErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class OrderServices implements OrderServicesImpl{

    @Autowired
    ItemsRepository itemsRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public ResponseEntity<?> submitItem ( OrderRequest order1 ) {
        OrderRes order = new OrderRes();
        InventoryRequest inventory = new InventoryRequest();
        Inventory inventory1 = new Inventory();
        inventory1.setStocks(inventory.getStocks());
        Items items = itemsRepository.findBySerialId(order1.getOrderId());
        inventory1.setItems(items);
        order.getItems().add(items);
        order.setOrderId(order1.getOrderId());
        order.setPurchased(order1.getPurchased());
        order.setQuantity(order1.getQuantity());
        order.setStatus(order1.getStatus());
        order.setTotal(order1.getTotal());
        order.setVat(order1.getVat());
        order.setPurchased(order1.getPurchased());

        Inventory getInventory = inventoryRepository.findByItems(items);

        System.out.println(getInventory);
        System.out.println(order1);

        if (order.getQuantity() == null){
            CustomErrorMessage errorMessage = new CustomErrorMessage();
            errorMessage.setError_code("Error 014");
            errorMessage.setError_message("Quantity is null");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } else if (getInventory.getStocks() < order1.getQuantity() && getInventory.getStocks() == 0) {
            CustomErrorMessage errorMessage = new CustomErrorMessage();
            errorMessage.setError_code("Error 019");
            errorMessage.setError_message("Stock is depleted.");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } else if (getInventory.getStocks() < order1.getQuantity()) {
            CustomErrorMessage errorMessage = new CustomErrorMessage();
            errorMessage.setError_code("Error 010");
            errorMessage.setError_message("Quantity is more than current stock");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } else if (order.getOrderId().isBlank()){
            CustomErrorMessage errorMessage = new CustomErrorMessage();
            errorMessage.setError_code("Error 012");
            errorMessage.setError_message("Order ID is blank");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } else if (order.getOrderId().isEmpty()){
            CustomErrorMessage errorMessage = new CustomErrorMessage();
            errorMessage.setError_code("Error 012");
            errorMessage.setError_message("Order ID is empty");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } else if (order.getOrderId() == null){
            CustomErrorMessage errorMessage = new CustomErrorMessage();
            errorMessage.setError_code("Error 013");
            errorMessage.setError_message("Order ID is null");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } else if (order.getTotal() == null){
            CustomErrorMessage errorMessage = new CustomErrorMessage();
            errorMessage.setError_code("Error 015");
            errorMessage.setError_message("Total is null");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } else if (order.getVat() == null){
            CustomErrorMessage errorMessage = new CustomErrorMessage();
            errorMessage.setError_code("Error 016");
            errorMessage.setError_message("Vat is null");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } else if (order.getStatus() == null){
            CustomErrorMessage errorMessage = new CustomErrorMessage();
            errorMessage.setError_code("Error 017");
            errorMessage.setError_message("Status is null");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }



        getInventory.setStocks(getInventory.getStocks() - order1.getQuantity());
        inventoryRepository.save(getInventory);

        ordersRepository.save(order);
        return new ResponseEntity<>("Order submitted", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> deleteItem ( OrderRes order, ModelMap model ) {
        model.remove(order);
        ordersRepository.delete(order);
        return new ResponseEntity<>("Successfully cancelled", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Double> getVat ( Long id ) {
        OrderRes order = ordersRepository.findOne(id);

        double total = order.getTotal();

        Double vat = total * .12;

        return new ResponseEntity<>(vat, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getItem ( Long id ) {
        return new ResponseEntity<>(ordersRepository.findAll(), HttpStatus.OK);
    }
}
