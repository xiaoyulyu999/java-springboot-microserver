package com.java_microserver.productservice.dto;

import java.math.BigDecimal;

public record ProductResponseDTO(
        String id,
        String name,
        String description,
        BigDecimal price
) {
}
