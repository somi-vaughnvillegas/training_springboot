package com.propelrr.springboot.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique = true)
    Long id;

    /*@GeneratedValue
    Long orderId;*/

    @OneToOne//(fetch = FetchType.LAZY)
    //@JoinColumn(name="Inventory_id")
    @JoinColumn(name = "items")
    Items items;


/*    @NotBlank(message = "not empty")
    @NotEmpty(message = "not empty")
    @NotNull(message = "not empty")
    //@Pattern(regexp="^(0|[1-9][0-9]*)$", message = "Numbers needed for this field.")
    @Range(min = 0, max = 100, message = "Numbers needed for this field.")
    //@Pattern(regexp = "(^$|[0-9]{10})", message = "Numbers only")
    @Digits(integer=6, fraction=2, message = "Numbers only")*/
    Integer stocks;
}
