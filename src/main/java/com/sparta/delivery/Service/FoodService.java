package com.sparta.delivery.Service;


import com.sparta.delivery.Model.Food;
import com.sparta.delivery.DTO.FoodDto;
import com.sparta.delivery.Repository.FoodRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FoodService {

    private final FoodRepository foodRepository;

    @Transactional
    public void registerFood(Long restaurantId, List<FoodDto> foodDto) {

        for (int i = 0; i < foodDto.size(); i++) {
            String name = foodDto.get(i).getName();
            int price = foodDto.get(i).getPrice();

            Optional<Food> found = foodRepository.findByNameAndRestaurantId(name, restaurantId);

            if (found.isPresent()) {
                throw new IllegalArgumentException("중복된 메뉴입니다.");
            }
            if (price < 100 || price > 1000000) {
                throw new IllegalArgumentException("주문가능금액 : 100원 ~ 1,000,000원");
            }
            if (price % 100 != 0) {
                throw new IllegalArgumentException("100원단위로 입력가능");
            }

            Food food = new Food(restaurantId, foodDto.get(i));
            foodRepository.save(food);
        }

    }
}
