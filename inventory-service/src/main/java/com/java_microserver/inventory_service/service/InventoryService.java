package com.java_microserver.inventory_service.service;


import com.java_microserver.inventory_service.Repository.InventoryRepository;
import com.java_microserver.inventory_service.dto.InventoryResponseDTO;
import com.java_microserver.inventory_service.model.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    @Transactional(readOnly = true)
    public List<InventoryResponseDTO> findInventoryOfSkuCodesDTO(List<String> skuCodes) {
        return inventoryRepository.findBySkuCodeIn(skuCodes)
                .stream()
                .map(inventoryMapper::toDTO)
                .collect(Collectors.toList());
    }
}
