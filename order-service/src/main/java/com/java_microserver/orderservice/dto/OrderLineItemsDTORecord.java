package com.java_microserver.orderservice.dto;

import java.math.BigDecimal;

public record OrderLineItemsDTORecord(
         Long id,
         String skuCode,
         BigDecimal price,
         Integer quantity
) {
}
