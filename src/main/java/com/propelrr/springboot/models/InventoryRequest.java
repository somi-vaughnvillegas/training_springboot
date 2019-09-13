package com.propelrr.springboot.models;

import lombok.Data;

@Data
public class InventoryRequest {
    public Integer stocks;
    public Long itemId;
}
