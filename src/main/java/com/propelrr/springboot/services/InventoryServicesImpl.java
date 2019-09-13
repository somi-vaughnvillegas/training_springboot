package com.propelrr.springboot.services;

import com.propelrr.springboot.models.InventoryRequest;
import org.springframework.http.ResponseEntity;

public interface InventoryServicesImpl {

    ResponseEntity<?> createInventory( InventoryRequest inventory );
    ResponseEntity<?> stockItem();
    ResponseEntity<?> reStock(Long id, Integer count);

}
