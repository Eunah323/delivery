package com.sparta.delivery.Service;

import com.sparta.delivery.DTO.OrderDto;
import com.sparta.delivery.DTO.OrderRequestDto;
import com.sparta.delivery.DTO.RestaurantDto;
import com.sparta.delivery.Model.Order;
import com.sparta.delivery.Model.OrderRequest;
import com.sparta.delivery.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final RestaurantDto restaurantDto;

    @Transactional
    public Order registerOrder(Long restaurantId, List<OrderDto> orderDto, List<OrderRequestDto> requestDto){
        int totalPrice = 0;
        for (int i = 0; i < orderDto.size(); i++) {
            for (int j = 0; j < requestDto.size(); i++) {
                String restaurantName = orderDto.get(i).getRestaurantName();
                int deliveryFee = orderDto.get(i).getDeliveryFee();
                String name = requestDto.get(j).getName();
                int quantity = requestDto.get(j).getQuantity();
                int price = requestDto.get(j).getPrice() * quantity;
                totalPrice += price;

                if(quantity<1){
                    throw new IllegalArgumentException("1개 이상 주문 해 주세요");
                }
                if(totalPrice < restaurantDto.getMinOrderPrice()){
                    throw new IllegalArgumentException("최소주문금액이상 주문이 필요합니다.");

                }


                Order order = new Order(restaurantId, orderDto.get(i), requestDto);
                orderRepository.save(order);
            }
        }

        return null;  }

}
