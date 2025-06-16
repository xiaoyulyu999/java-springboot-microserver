package com.java_microserver.inventory_service.controller;


import com.java_microserver.inventory_service.dto.InventoryResponseDTO;
import com.java_microserver.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponseDTO> findInventoryOfSkuCodesDTO(@RequestParam List<String> skuCodes) {
        return inventoryService.findInventoryOfSkuCodesDTO(skuCodes);

    }
}
