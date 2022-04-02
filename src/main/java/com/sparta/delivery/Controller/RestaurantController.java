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
@Controller
//가게주인이 가게정보를 등록하는 컨트롤러
public class RestaurantController {


    private final RestaurantService restaurantService;
    private final RestaurantRepository restaurantRepository;

    //    @PostMapping("/restaurant/register")
//    public Restaurant createRestarant(@RequestBody RestaurantDto requestDto) {
//
//        Restaurant restaurant = new Restaurant(requestDto);
//
//        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
//        return restaurantRepository.save(restaurant);
//    }
    @PostMapping("/restaurant/register")
    public String registerRestaurant(RestaurantDto requestDto, Model model) {
        if (restaurantService.registerRestaurant(requestDto).equals("")) {
            Restaurant restaurant = new Restaurant(requestDto);
            restaurantRepository.save(restaurant);
            return "Restaurant";
        } else {
            model.addAttribute("errortext", restaurantService.registerRestaurant(requestDto));
            return "register";
        }
    }

    @ResponseBody
    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant() {
        return restaurantRepository.findAll();
    }


}
