package com.propelrr.springboot.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Items {

    @Id
    @GeneratedValue
    @Column(unique = true)
    Long id;

    @JsonIgnore
    @ManyToMany(mappedBy = "items")
    List<OrderRes> orderId;


    @Column(unique = true)
    String serialId;


    String name;


    String description;


    Double price;



}