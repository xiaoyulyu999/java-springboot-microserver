package com.java_microserver.orderservice.dto;

import java.util.List;

public record OrderRequestDTO(
        List<OrderLineItemsDTORecord> orderLineItemsDTORecords
) {
}
