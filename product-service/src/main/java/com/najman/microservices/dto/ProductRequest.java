package com.najman.microservices.dto;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document("product")
public class ProductRequest {


    private String name;
    private String description;
    private BigDecimal price;

}
