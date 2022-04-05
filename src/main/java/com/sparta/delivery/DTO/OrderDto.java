package com.sparta.delivery.DTO;

import com.sparta.delivery.Model.OrderRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class OrderDto {
    private String restaurantName;
    private List<OrderRequest> orderRequests;
    private int deliveryFee;
    private int totalPrice;
}
