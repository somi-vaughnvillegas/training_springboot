package com.propelrr.springboot.services;

import com.propelrr.springboot.models.Inventory;
import com.propelrr.springboot.models.InventoryRequest;
import com.propelrr.springboot.models.Items;
import com.propelrr.springboot.repositories.InventoryRepository;
import com.propelrr.springboot.repositories.ItemsRepository;
import com.propelrr.springboot.validators.CustomErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InventoryServices implements InventoryServicesImpl{
    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    ItemsRepository itemsRepository;

    @Override
    public ResponseEntity<?> createInventory ( InventoryRequest inventory ) {
        Inventory inventory1 = new Inventory();
        Items items = itemsRepository.findOne(inventory.getItemId());
        inventory1.setItems(items);
        inventory1.setStocks(inventory.getStocks());

        if (inventory1.getStocks() == null){
            CustomErrorMessage errorMessage = new CustomErrorMessage();
            errorMessage.setError_code("Error 018");
            errorMessage.setError_message("Stocks is null");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }

        inventoryRepository.save(inventory1);
        return new ResponseEntity<>( "successfully created", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> stockItem () {
        return new ResponseEntity<>(inventoryRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> reStock ( Long id, Integer count ) {
        Inventory inventory = inventoryRepository.findOne(id);

        int total = inventory.getStocks() + count;

        inventory.setStocks(total);


        inventoryRepository.save(inventory);
        return new ResponseEntity<>("Successfully added",HttpStatus.OK);
    }
}
