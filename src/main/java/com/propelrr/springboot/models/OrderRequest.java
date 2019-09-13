package com.propelrr.springboot.models;


import lombok.Data;

import java.util.Date;

@Data
public class OrderRequest {

    public String orderId; //
    public Integer quantity; //
    public Double total; //
    public Double vat; //
    public Date purchased; //
    public Integer status; //
}
