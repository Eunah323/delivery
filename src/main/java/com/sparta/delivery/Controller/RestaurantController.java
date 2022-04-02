package com.sparta.delivery.Controller;

import com.sparta.delivery.DTO.RestaurantDto;

import com.sparta.delivery.Model.Restaurant;
import com.sparta.delivery.Repository.RestaurantRepository;
import com.sparta.delivery.Service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
//가게주인이 가게정보를 등록하는 컨트롤러
public class RestaurantController {


    private final RestaurantService restaurantService;
    private final RestaurantRepository restaurantRepository;


    @PostMapping("/restaurant/register")
    public Restaurant createRestaurant(@RequestBody RestaurantDto requestDto) {

        return restaurantService.registerRestaurant(requestDto);
    }

        @GetMapping("/restaurants")
        public List<Restaurant> getRestaurant () {return restaurantRepository.findAll();}


    }

