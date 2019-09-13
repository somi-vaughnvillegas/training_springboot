package com.propelrr.springboot.validators;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<CustomErrorMessage> handleValidationExceptions(
            HttpMessageNotReadableException ex) {

        CustomErrorMessage errorMessage = new CustomErrorMessage();
        errorMessage.setError_code("Error 001");
        errorMessage.setError_message("Invalid value");

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
