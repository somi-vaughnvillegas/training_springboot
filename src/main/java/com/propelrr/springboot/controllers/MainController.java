package com.propelrr.springboot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping(path = "/")
    public @ResponseBody ResponseEntity<String> printHelloWorld() {
        return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
    }

}
