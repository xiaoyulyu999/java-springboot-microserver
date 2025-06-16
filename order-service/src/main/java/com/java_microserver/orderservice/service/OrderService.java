package com.java_microserver.orderservice.service;

import com.java_microserver.orderservice.dto.InventoryResponseDTO;
import com.java_microserver.orderservice.dto.OrderRequestDTO;
import com.java_microserver.orderservice.dto.OrderResponseDTO;
import com.java_microserver.orderservice.model.Order;
import com.java_microserver.orderservice.model.OrderLineItems;
import com.java_microserver.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final WebClient webClient;

    public void placeOrder(OrderRequestDTO orderRequestDTO) {
        Order order = orderMapper.orderRequestDTOToOrder(orderRequestDTO);

        List<String> skuCodeList = order.getOrderLineItemsList()
                .stream().map(OrderLineItems::getSkuCode).toList();

        InventoryResponseDTO[] webBlock = webClient
                .get()
                .uri("http://localhost:8082/api/inventory", uriBuilder -> uriBuilder.queryParam("skuCode", skuCodeList).build() )
                .retrieve()
                .bodyToMono(InventoryResponseDTO[].class)
                .block();

        assert webBlock != null;

        boolean allInStock = Arrays.stream(webBlock)
                .allMatch(inventoryResponseDTO-> inventoryResponseDTO.quantity() > 0);

        if (allInStock) {
            orderRepository.save(order);
            log.info("Placed order: {}", order);
        } else {
            throw new IllegalStateException("Web block not present - check your inventory");
        }
    }

    public List<OrderResponseDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::orderIntoOrderResponseDTO)
                .collect(Collectors.toList());
    }

}
