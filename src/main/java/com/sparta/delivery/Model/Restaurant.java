package com.sparta.delivery.Model;


import com.sparta.delivery.DTO.RestaurantDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Restaurant {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int minOrderPrice;

    @Column(nullable = false)
    private int deliveryFee;


    public Restaurant(String name, int minOrderPrice, int deliveryFee) {
        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
    }

    public Restaurant(RestaurantDto restaurantDto) {
        this.name = restaurantDto.getName();
        this.minOrderPrice = restaurantDto.getMinOrderPrice();
        this.deliveryFee = restaurantDto.getDeliveryFee();
    }

}
