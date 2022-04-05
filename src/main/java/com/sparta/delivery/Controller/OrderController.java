package com.sparta.delivery.Controller;

import com.sparta.delivery.DTO.OrderDto;
import com.sparta.delivery.DTO.OrderRequestDto;
import com.sparta.delivery.DTO.RestaurantDto;
import com.sparta.delivery.Model.Order;
import com.sparta.delivery.Model.Restaurant;
import com.sparta.delivery.Repository.RestaurantRepository;
import com.sparta.delivery.Service.OrderService;
import com.sparta.delivery.Service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {
    private final OrderService orderService;
    private final RestaurantRepository restaurantRepository;

    @PostMapping("/order/request")
    public Order createOrder(Long restaurantId, @RequestBody List<OrderDto> orderDto, List<OrderRequestDto> requestDto ) {

        return orderService.registerOrder(restaurantId, orderDto, requestDto);
    }
}
