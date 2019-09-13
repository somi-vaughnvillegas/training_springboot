package com.propelrr.springboot.services;

import com.propelrr.springboot.models.OrderRequest;
import com.propelrr.springboot.models.OrderRes;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;

public interface OrderServicesImpl {

    ResponseEntity<?> submitItem( OrderRequest order1 );
    ResponseEntity<?> deleteItem( OrderRes order, ModelMap model );
    ResponseEntity<?> getVat(Long id);
    ResponseEntity<?> getItem(Long id);
}
