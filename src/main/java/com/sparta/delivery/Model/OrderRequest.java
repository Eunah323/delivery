package com.sparta.delivery.Model;

import com.sparta.delivery.DTO.OrderRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class OrderRequest {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "Order")
    private Order order;

    public OrderRequest(OrderRequestDto orderRequestDto){
        this.name = orderRequestDto.getName();
        this.quantity = orderRequestDto.getQuantity();
        this.price = orderRequestDto.getPrice();
    }


}
