package com.sparta.delivery.Model;

import com.sparta.delivery.DTO.FoodDto;
import com.sparta.delivery.Repository.RestaurantRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Food {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @OneToMany(mappedBy = "Food", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Column(nullable = false)
    @JoinColumn(name = "restaurantId")
    private List<Restaurant> restaurantList;
    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    public Food(List<Restaurant> restaurantList, String name, int price) {
        this.restaurantList = restaurantList;
        this.name = name;
        this.price = price;
    }

    public Food(List<Restaurant> restaurantList, FoodDto foodDto) {
        this.restaurantList = restaurantList;
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
    }



}
