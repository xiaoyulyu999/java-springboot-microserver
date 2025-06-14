package com.java_microserver.orderservice.controller;

import com.java_microserver.orderservice.dto.OrderRequest;
import com.java_microserver.orderservice.dto.OrderRequestDTO;
import com.java_microserver.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
