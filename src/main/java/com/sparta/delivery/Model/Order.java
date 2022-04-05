package com.sparta.delivery.Model;

import com.sparta.delivery.DTO.OrderDto;
import com.sparta.delivery.DTO.OrderRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String restaurantName;

    @Column
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderRequest> orderRequests;


    @Column(nullable = false)
    private int deliveryFee;

    @Column(nullable = false)
    private int totalPrice;

    public Order(String restaurantName, List<OrderRequest> orderRequests, int deliveryFee, int totalPrice){
        this.restaurantName = restaurantName;
        this.orderRequests = orderRequests;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }

    public Order(Long restaurantId, OrderDto orderDto, List<OrderRequestDto> requestDto){
        this.restaurantName = orderDto.getRestaurantName();
        this.orderRequests = orderDto.getOrderRequests();
        this.deliveryFee = orderDto.getDeliveryFee();
        this.totalPrice = orderDto.getTotalPrice();
    }


}
