package com.java_microserver.orderservice.dto;

public record InventoryResponseDTO(
        Long id,
        int quantity,
        String skuCode
) {
}
