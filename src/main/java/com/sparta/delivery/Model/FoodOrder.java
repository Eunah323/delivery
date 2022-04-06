package com.sparta.delivery.Model;

import com.sparta.delivery.DTO.FoodDto;
import com.sparta.delivery.DTO.FoodOrderDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class FoodOrder {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private int quantity;
    @Column
    private int price;

    @ManyToOne
    @JoinColumn(name = "FOOD_ORDERS")
    private Order order;

    public FoodOrder(FoodOrderDto orderDto) {

        this.name = orderDto.getName();
        this.quantity = orderDto.getQuantity();
        this.price = orderDto.getPrice();
    }


}
