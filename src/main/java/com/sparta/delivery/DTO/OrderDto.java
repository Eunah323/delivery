package com.sparta.delivery.DTO;

import lombok.Getter;

import java.util.List;
@Getter

public class OrderDto {
    private String restaurantName;
    private List<FoodOrderDto> foods;
    private int deliveryFee;
    private int totalPrice;
}
