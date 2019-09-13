package com.propelrr.springboot.controllers;

import com.propelrr.springboot.models.InventoryRequest;
import com.propelrr.springboot.repositories.InventoryRepository;
import com.propelrr.springboot.repositories.ItemsRepository;
import com.propelrr.springboot.services.InventoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
/*@Validated*/
public class InventoryController {

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    ItemsRepository itemsRepository;

    @Autowired
    InventoryServices inventoryServices;

    @PostMapping("/inventory/stock")
    public @ResponseBody ResponseEntity<?> createInventory(
            @RequestBody InventoryRequest inventory
    ) {
        return inventoryServices.createInventory(inventory);
    }

    @GetMapping("/inventory/stock/list")
    public @ResponseBody ResponseEntity<?> stockItems(){
        return inventoryServices.stockItem();
    }

    @RequestMapping(value = "/inventory/stock/{id}", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<?> reStock (
            @PathVariable Long id, @RequestParam Integer count )
    {
        return inventoryServices.reStock(id, count);
    }
}
