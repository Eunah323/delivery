package com.sparta.delivery.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodOrderRequestDto {
    private Long id;
    private int quantity;

}
