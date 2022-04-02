package com.sparta.delivery.Model;

import com.sparta.delivery.DTO.FoodDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Food {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long restaurantId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    public Food(Long restaurantId, String name, int price) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
    }

    public Food(FoodDto foodDto) {
        this.restaurantId = foodDto.getRestaurantId();
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
    }
}
