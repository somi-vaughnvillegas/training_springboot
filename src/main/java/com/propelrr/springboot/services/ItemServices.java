package com.propelrr.springboot.services;

import com.propelrr.springboot.models.ItemRequest;
import com.propelrr.springboot.models.Items;
import com.propelrr.springboot.repositories.ItemsRepository;
import com.propelrr.springboot.validators.CustomErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServices implements ItemInterServices {

    @Autowired
    ItemsRepository itemsRepository;


    @Override
    public ResponseEntity<?> createItem ( Items item ) {

        if (item.getPrice() == null){
            CustomErrorMessage errorMessage = new CustomErrorMessage();
            errorMessage.setError_code("Error 002");
            errorMessage.setError_message("Price is null");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } else if (item.getName() == null){
            CustomErrorMessage errorMessage = new CustomErrorMessage();
            errorMessage.setError_code("Error 003");
            errorMessage.setError_message("Name is null");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } else if (item.getSerialId() == null){
            CustomErrorMessage errorMessage = new CustomErrorMessage();
            errorMessage.setError_code("Error 004");
            errorMessage.setError_message("Serial ID is null");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } else if (item.getDescription() == null){
            CustomErrorMessage errorMessage = new CustomErrorMessage();
            errorMessage.setError_code("Error 005");
            errorMessage.setError_message("Description is null");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } else if (item.getDescription().isEmpty()){
            CustomErrorMessage errorMessage = new CustomErrorMessage();
            errorMessage.setError_code("Error 006");
            errorMessage.setError_message("Description is empty");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } else if (item.getDescription().isBlank()){
            CustomErrorMessage errorMessage = new CustomErrorMessage();
            errorMessage.setError_code("Error 007");
            errorMessage.setError_message("Description is blank");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } else if (item.getName().isEmpty()){
            CustomErrorMessage errorMessage = new CustomErrorMessage();
            errorMessage.setError_code("Error 008");
            errorMessage.setError_message("Name is empty");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        } else if (item.getName().isBlank()){
            CustomErrorMessage errorMessage = new CustomErrorMessage();
            errorMessage.setError_code("Error 009");
            errorMessage.setError_message("Name is blank");
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }

        itemsRepository.save(item);


        return new ResponseEntity<>( "successfully created", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateItem (Long id, ItemRequest item ) {

        Items itemToUpdate = itemsRepository.findOne(id);
        itemToUpdate.setName(item.getName());
        itemToUpdate.setDescription(item.getDescription());

        itemsRepository.save(itemToUpdate);
        return new ResponseEntity<>( "Successfully updated", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteItem ( Long id ) {

        itemsRepository.delete(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getItems ( ) {
        List<Items> itemsList = itemsRepository.findAll();
        return new ResponseEntity<>(itemsList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getItem ( Long id ) {
        return new ResponseEntity<>(itemsRepository.findOne(id), HttpStatus.OK);
    }

}
