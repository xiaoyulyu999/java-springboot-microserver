package com.java_microserver.orderservice.service;


import com.java_microserver.orderservice.dto.OrderLineItemsDTORecord;
import com.java_microserver.orderservice.dto.OrderRequestDTO;
import com.java_microserver.orderservice.dto.OrderResponseDTO;
import com.java_microserver.orderservice.model.Order;
import com.java_microserver.orderservice.model.OrderLineItems;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderMapper {

    public Order orderRequestDTOToOrder(OrderRequestDTO orderRequestDTO) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderLineItemsList(orderLineItemsDTORecordsToOrderLineItems(orderRequestDTO.orderLineItemsDTORecords()));
        return order;
    }

    public List<OrderLineItems> orderLineItemsDTORecordsToOrderLineItems(List<OrderLineItemsDTORecord> orderLineItemsDTORecords) {
        return orderLineItemsDTORecords
                .stream()
                .map(this::dtoMapto)
                .toList();
    }

    private OrderLineItems dtoMapto(OrderLineItemsDTORecord orderLineItemsDTORecord) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setQuantity(orderLineItemsDTORecord.quantity());
        orderLineItems.setSkuCode(orderLineItemsDTORecord.skuCode());
        orderLineItems.setPrice(orderLineItemsDTORecord.price());
        return orderLineItems;
    }

    public OrderResponseDTO orderIntoOrderResponseDTO(Order order) {
        int orderQuantity = order.getOrderLineItemsList().size();
        return new OrderResponseDTO(order.getId(), order.getOrderNumber(), orderQuantity);
    }
}
