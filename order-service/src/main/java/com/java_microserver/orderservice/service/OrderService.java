package com.java_microserver.orderservice.service;

import com.java_microserver.orderservice.dto.OrderRequestDTO;
import com.java_microserver.orderservice.dto.OrderResponseDTO;
import com.java_microserver.orderservice.model.Order;
import com.java_microserver.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public void placeOrder(OrderRequestDTO orderRequestDTO) {
        orderMapper.orderRequestDTOToOrder(orderRequestDTO);
    }

    public List<OrderResponseDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::orderIntoOrderResponseDTO)
                .collect(Collectors.toList());
    }

}
