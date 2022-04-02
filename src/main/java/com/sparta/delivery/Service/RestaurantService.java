package com.sparta.delivery.Service;

import com.sparta.delivery.DTO.RestaurantDto;
import com.sparta.delivery.Model.Restaurant;
import com.sparta.delivery.Repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Restaurant registerRestaurant(@RequestBody RestaurantDto requestDto) {

        String name = requestDto.getName();
        int minOrderPrice = requestDto.getMinOrderPrice();
        int deliveryFee = requestDto.getDeliveryFee();

        if (minOrderPrice < 1000 || minOrderPrice > 100000) {
            throw new IllegalArgumentException("주문가능금액 : 1,000원 ~ 100,000원");
        }
        if (minOrderPrice % 100 != 0) {
            throw new IllegalArgumentException("100원단위로 적어주세요");
        }
        if (deliveryFee < 0 || deliveryFee > 10000) {
            throw new IllegalArgumentException( "배달료 범위: 0원 ~ 10,000원");
        }
        if (deliveryFee % 500 != 0) {
            throw new IllegalArgumentException( "500원 단위로 적어주세요");
        }
        Restaurant restaurant = new Restaurant(requestDto);
//        restaurantRepository.save(restaurant);
        return restaurantRepository.save(restaurant);
    }
}

