package com.java_microserver.productservice.dto;

import java.math.BigDecimal;

public record ProductRequestDTO(
        String name,
        String description,
        BigDecimal price
) {
}
