package com.sparta.delivery.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@Table(name = "my_order")
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    @Column
    private String restaurantName;

    @OneToMany(targetEntity = FoodOrder.class, cascade = CascadeType.ALL)
    @Column
    private List<FoodOrder> foodOrders;

    @Column
    private int deliveryFee;

    @Column
    private int totalPrice;

    public Order(String restaurantName, List<FoodOrder> foodOrders, int deliveryFee, int totalPrice){
        this.restaurantName = restaurantName;
        this.foodOrders = foodOrders;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }

}
