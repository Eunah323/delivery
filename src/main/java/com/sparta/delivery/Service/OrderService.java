package com.sparta.delivery.Service;

import com.sparta.delivery.DTO.FoodOrderDto;
import com.sparta.delivery.DTO.FoodOrderRequestDto;
import com.sparta.delivery.DTO.OrderRequestDto;
import com.sparta.delivery.Model.Food;
import com.sparta.delivery.Model.FoodOrder;
import com.sparta.delivery.Model.Order;
import com.sparta.delivery.Model.Restaurant;
import com.sparta.delivery.Repository.FoodOrderRepository;
import com.sparta.delivery.Repository.FoodRepository;
import com.sparta.delivery.Repository.OrderRepository;
import com.sparta.delivery.Repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;
    private final OrderRepository orderRepository;
    private final FoodOrderRepository foodOrderRepository;


    @Transactional
    public Order registerOrder(OrderRequestDto orderDto) {
        Restaurant restaurant = restaurantRepository.findById(orderDto.getRestaurantId()).orElseThrow(
                () -> new IllegalArgumentException(""));

        int totalPrice = 0;
        int minOrderPrice = restaurant.getMinOrderPrice();


        List<FoodOrder> foodOrders = new ArrayList<>();
        Long restaurantId = orderDto.getRestaurantId();
        String restaurantName = restaurant.getName();
        int deliveryFee = restaurant.getDeliveryFee();

        for (int i = 0; i < orderDto.getFoods().size(); i++) {
            FoodOrderRequestDto foodOrderRequestDto = orderDto.getFoods().get(i);
            Food food = foodRepository.findByIdAndRestaurantId(foodOrderRequestDto.getId(), restaurantId).orElseThrow(
                    () -> new IllegalArgumentException(""));
            String name = food.getName();
            int quantity = orderDto.getFoods().get(i).getQuantity();
            int price = food.getPrice();
            totalPrice += quantity * price;
            if (totalPrice < minOrderPrice) {
                throw new IllegalArgumentException("최소주문금액 이상 주문해주세요.");
            }
            if (quantity < 1 || quantity > 100) {
                throw new IllegalArgumentException("주문가능수량은 1개~100개 입니다.");
            }

            FoodOrderDto foodOrderDto = new FoodOrderDto();
            foodOrderDto.setName(name);
            foodOrderDto.setQuantity(quantity);
            foodOrderDto.setPrice(price * quantity);


            FoodOrder foodOrder = new FoodOrder(foodOrderDto);
            foodOrderRepository.save(foodOrder);
            foodOrders.add(foodOrder);
        }
        totalPrice += deliveryFee;

        Order order = new Order(restaurantName, foodOrders, deliveryFee, totalPrice);
        orderRepository.save(order);
        System.out.println(order);
        return order;
    }
}
