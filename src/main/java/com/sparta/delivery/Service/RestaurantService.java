package com.sparta.delivery.Service;

import com.sparta.delivery.DTO.RestaurantDto;
import com.sparta.delivery.Model.Restaurant;
import com.sparta.delivery.Repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public String registerRestaurant(RestaurantDto requestDto) {
        String error = "";
        String name = requestDto.getName();
        int minOrderPrice = requestDto.getMinOrderPrice();
        int deliveryFee = requestDto.getDeliveryFee();
        Optional<Restaurant> found = restaurantRepository.findByName(name);

        if (found.isPresent()) {
            return "중복된 점포 입니다.";
        } else if (minOrderPrice < 1000 || minOrderPrice > 100000 || minOrderPrice % 100 != 0) {
            return "주문가능금액 : 1,000원 ~ 100,000원 / 100원단위로 적어주세요";
        } else if (deliveryFee < 0 || deliveryFee > 10000 || deliveryFee % 500 != 0) {
            return "배달료 범위: 0원 ~ 10,000원 / 500원 단위로 적어주세요";
        }
        Restaurant restaurant = new Restaurant(name, minOrderPrice, deliveryFee);
        restaurantRepository.save(restaurant);
        return error;
    }
}

