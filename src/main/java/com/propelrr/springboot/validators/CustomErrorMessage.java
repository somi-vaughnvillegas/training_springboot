package com.propelrr.springboot.validators;

import lombok.Data;

@Data
public class CustomErrorMessage {
    private String error_code;
    private String error_message;
}
