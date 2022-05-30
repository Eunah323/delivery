package com.sparta.delivery.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@Table(name = "my_order")
public class MyOrder {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String restaurantName;

    @OneToMany
    @JoinColumn
    private List<FoodOrder> foods;

    @Column
    private int deliveryFee;

    @Column
    private int totalPrice;

    public MyOrder(String restaurantName, List<FoodOrder> foods, int deliveryFee, int totalPrice){
        this.restaurantName = restaurantName;
        this.foods = foods;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }

}
