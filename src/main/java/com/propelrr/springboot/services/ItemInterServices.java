package com.propelrr.springboot.services;


import com.propelrr.springboot.models.ItemRequest;
import com.propelrr.springboot.models.Items;
import org.springframework.http.ResponseEntity;

public interface ItemInterServices {

     ResponseEntity<?> createItem( Items item );
    ResponseEntity<?> updateItem(Long id, ItemRequest item);
    ResponseEntity<?> deleteItem(Long id);
    ResponseEntity<?> getItems();
    ResponseEntity<?> getItem(Long id);

}
