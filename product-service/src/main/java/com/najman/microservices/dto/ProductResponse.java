package com.najman.microservices.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document("product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductResponse {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;

}
