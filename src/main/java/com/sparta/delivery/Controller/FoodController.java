package com.sparta.delivery.Controller;

import com.sparta.delivery.DTO.FoodDto;
import com.sparta.delivery.DTO.RestaurantDto;
import com.sparta.delivery.Model.Food;
import com.sparta.delivery.Model.Restaurant;
import com.sparta.delivery.Repository.FoodRepository;
import com.sparta.delivery.Service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodController {
    private final FoodRepository foodRepository;
    private final FoodService foodService;

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void createFood(@PathVariable Long restaurantId, @RequestBody  List<FoodDto> foodDto) {

       foodService.registerFood(restaurantId, foodDto);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public  List<Food> getFood(@PathVariable Long restaurantId) {
        return foodRepository.findAllByRestaurantId(restaurantId);
    }
}



