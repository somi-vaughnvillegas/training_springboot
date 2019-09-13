package com.propelrr.springboot.controllers;

import com.propelrr.springboot.models.ItemRequest;
import com.propelrr.springboot.models.Items;
import com.propelrr.springboot.repositories.ItemsRepository;
import com.propelrr.springboot.services.ItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemsController {

    @Autowired
    ItemsRepository itemsRepository;

    @Autowired
    ItemServices itemServices;

    @PostMapping("/items/create")
    public @ResponseBody ResponseEntity<?> createItem(
            @RequestBody Items item
    ) {

        return itemServices.createItem(item);

    }

    @GetMapping("/items/list")
    public @ResponseBody ResponseEntity<?> getAllItem(){
        return itemServices.getItems();
    }

    @GetMapping("/items/{id}")
    public @ResponseBody ResponseEntity<?> getItem(@PathVariable Long id){
        return itemServices.getItem(id);
    }

    @PutMapping("/items/{id}")
    public @ResponseBody ResponseEntity<?> updateItem(@PathVariable Long id,
            @RequestBody ItemRequest item){

        return itemServices.updateItem(id, item);
    }

    @DeleteMapping("/items/{id}")
    public @ResponseBody ResponseEntity<?> updateItem(
            @PathVariable Long id){

        return itemServices.deleteItem(id);
    }



}
