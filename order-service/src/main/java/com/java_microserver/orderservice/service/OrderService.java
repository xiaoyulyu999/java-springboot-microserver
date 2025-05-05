package com.java_microserver.orderservice.service;

import com.java_microserver.orderservice.dto.OrderLineItemsDto;
import com.java_microserver.orderservice.dto.OrderRequest;
import com.java_microserver.orderservice.model.Order;
import com.java_microserver.orderservice.model.OrderLineItems;
import com.java_microserver.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItemsList(orderLineItems);
        orderRepository.save(order);
        log.info("Order placed successfully: {}", order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto oderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(oderLineItemsDto.getPrice());
        orderLineItems.setQuantity(oderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(oderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
