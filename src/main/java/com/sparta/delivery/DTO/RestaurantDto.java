package com.sparta.delivery.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
//@NoArgsConstructor
//@AllArgsConstructor
@Setter
public class RestaurantDto {
//    private Long id;
    private String name;
    private int minOrderPrice;
    private int deliveryFee;
}
