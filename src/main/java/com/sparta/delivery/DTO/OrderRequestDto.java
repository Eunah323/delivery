package com.sparta.delivery.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {
    String name;
    int quantity;
    int price;
}
