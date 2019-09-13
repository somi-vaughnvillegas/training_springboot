package com.propelrr.springboot.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class OrderRes {

    @Id
    @GeneratedValue
    @Column(unique = true)
    Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Items_ID",
            joinColumns = @JoinColumn(name = "OrderRes_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Items_id", referencedColumnName = "id"))
    List<Items> items = new ArrayList<>();

/*    @NotBlank(message = "not empty")
    @NotEmpty(message = "not empty")
    @NotNull(message = "not empty")*/
    @Column(unique = true)
    String orderId;

/*    //@Pattern(regexp="^(0|[1-9][0-9]*)$", message = "Numbers needed for this field.")
    @Range(min = 0, max = 100, message = "Numbers needed for this field.")
    //@Pattern(regexp = "(^$|[0-9]{10})", message = "Numbers only")
    @Digits(integer=6, fraction=2, message = "Numbers only")
    //@NotBlank(message = "not empty")
    //@NotEmpty(message = "not empty")
    @NotNull(message = "not empty")*/
    Integer quantity;

/*    //@Pattern(regexp="^(0|[1-9][0-9]*)$", message = "Numbers needed for this field.")
    @DecimalMax(value ="1000.0", message = "Should have numbers") @DecimalMin(value = "0.0000001", message = "Should have numbers")
    //@Pattern(regexp = "(^$|[0-9]{10})", message = "Numbers only")
    @Digits(integer=6, fraction=2, message = "Numbers only")
    //@NotBlank(message = "not empty")
    //@NotEmpty(message = "not empty")
    @NotNull(message = "not empty")*/
    Double total;

/*    //@Pattern(regexp="^(0|[1-9][0-9]*)$", message = "Numbers needed for this field.")
    @DecimalMax(value = "1000.0", message = "Should have numbers") @DecimalMin(value = "0.0000001", message = "Should have numbers")
    //@Pattern(regexp = "(^$|[0-9]{10})", message = "Numbers only")
    @Digits(integer=6, fraction=2, message = "Numbers only")
    //@NotBlank(message = "not empty")
    //@NotEmpty(message = "not empty")
    @NotNull(message = "not empty")*/
    Double vat;

    //@Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    Date purchased;

/*    //@Pattern(regexp = "(^$|[0-9]{10})", message = "Numbers only")
    @Digits(integer=6, fraction=2, message = "Numbers only")
    @Range(min = 1, max = 100, message = "Numbers needed for this field.")
    //@NotBlank(message = "not empty")
    @NotEmpty(message = "not empty")
    @NotNull(message = "not empty")*/
    Integer status;
}
