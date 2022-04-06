package com.sparta.delivery.DTO;


import lombok.Getter;

import java.util.List;
@Getter

public class OrderRequestDto {
    private Long restaurantId;
    private List<FoodOrderRequestDto> foods;


}
