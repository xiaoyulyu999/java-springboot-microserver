package com.java_microserver.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
//@AllArgsConstructor	Generates a constructor with all fields
//@NoArgsConstructor	Generates a no-arguments constructor
//@Builder	Creates a builder pattern for easy object creation
//@Data	Combines @Getter, @Setter, @ToString, @EqualsAndHashCode, and @RequiredArgsConstructor
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
