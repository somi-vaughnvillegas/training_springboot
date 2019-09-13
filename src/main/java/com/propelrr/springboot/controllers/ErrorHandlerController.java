/*
package com.propelrr.springboot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;

@ControllerAdvice
public class ErrorHandlerController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public void springHandleNotFound( HttpServletResponse response ) throws IOException {
        System.out.println("error");
        response.sendError(HttpStatus.NOT_ACCEPTABLE.value());
    }
}
*/
