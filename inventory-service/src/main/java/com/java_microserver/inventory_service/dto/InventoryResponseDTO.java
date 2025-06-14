package com.java_microserver.inventory_service.dto;

public record InventoryResponseDTO(
        Long id,
        int quantity,
        String skuCode
) {
}
