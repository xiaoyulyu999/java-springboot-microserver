package com.java_microserver.orderservice.dto;

import java.math.BigDecimal;

public record OrderResponseDTO(
        Long id,
        String orderNumber,
        Integer orderQuantity
) {
}
