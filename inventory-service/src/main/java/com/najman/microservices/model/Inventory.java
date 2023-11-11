package com.najman.microservices.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "t_inventory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String skuCode;
    private Integer quantity;
}


