package com.java_microserver.orderservice.service;

import com.java_microserver.orderservice.dto.OrderRequestDTO;
import com.java_microserver.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
