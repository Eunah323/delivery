package com.sparta.delivery.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequestDto {
    private Long restaurantId;
    private List<FoodOrderRequestDto> foods;


}
