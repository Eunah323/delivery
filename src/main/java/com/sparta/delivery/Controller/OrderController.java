package com.sparta.delivery.Controller;


import com.sparta.delivery.DTO.OrderDto;
import com.sparta.delivery.DTO.OrderRequestDto;
import com.sparta.delivery.DTO.RestaurantDto;
import com.sparta.delivery.Model.Order;
import com.sparta.delivery.Model.Restaurant;
import com.sparta.delivery.Repository.OrderRepository;
import com.sparta.delivery.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {
    private final OrderService orderService;
    private final OrderRepository orderRepository;



    @PostMapping("/order/request")
    public Order createOrder(@RequestBody OrderRequestDto orderDto) {

        return orderService.registerOrder(orderDto);
    }

    @GetMapping("/orders")
    public List<Order> getOrder () {return orderRepository.findAll();}


}



