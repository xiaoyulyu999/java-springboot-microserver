package com.java_microserver.inventory_service.service;

import com.java_microserver.inventory_service.dto.InventoryResponseDTO;
import com.java_microserver.inventory_service.model.Inventory;
import org.springframework.stereotype.Service;

@Service
public class InventoryMapper {

    public InventoryResponseDTO toDTO(Inventory inventory) {

        return new InventoryResponseDTO(inventory.getId(), inventory.getQuantity(), inventory.getSkuCode());
    }
}
