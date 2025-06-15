package com.java_microserver.orderservice.controller;

import com.java_microserver.orderservice.dto.OrderRequestDTO;
import com.java_microserver.orderservice.dto.OrderResponseDTO;
import com.java_microserver.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        orderService.placeOrder(orderRequestDTO);
        return "Order placed successfully";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponseDTO> getOrders() {
        return orderService.getAllOrders();
    }
}
