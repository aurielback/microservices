package com.najman.microservices.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponse {

    private String skuCode;
    private Integer quantity;
}
