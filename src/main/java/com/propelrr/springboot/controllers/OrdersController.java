package com.propelrr.springboot.controllers;


import com.propelrr.springboot.models.OrderRequest;
import com.propelrr.springboot.models.OrderRes;
import com.propelrr.springboot.repositories.InventoryRepository;
import com.propelrr.springboot.repositories.ItemsRepository;
import com.propelrr.springboot.repositories.OrdersRepository;
import com.propelrr.springboot.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
/*@Validated*/
@Configurable
public class OrdersController {

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ItemsRepository itemsRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    OrderServices orderServices;

    @RequestMapping(value = "/order/submit", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<?> submitItem(
            @RequestBody OrderRequest order1)
     {

         return orderServices.submitItem(order1);


    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<?> deleteItem (
            OrderRes order, ModelMap model)
    {
        return orderServices.deleteItem(order, model);
    }

    @GetMapping("/order/{id}")
    public @ResponseBody ResponseEntity<?> getItem(@PathVariable Long id){
        return orderServices.getItem(id);
    }

    @RequestMapping(value = "/order/vat/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Double> getVat(
            @PathVariable Long id)
    {

        return orderServices.getVat(id);
    }

}

