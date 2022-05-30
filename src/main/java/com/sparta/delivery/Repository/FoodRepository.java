package com.sparta.delivery.Repository;

import com.sparta.delivery.Model.Food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    Optional<Food> findByNameAndRestaurantId(String name, Long restaurantId);
    List<Food> findAllByRestaurantId(Long restaurantId);

    Optional <Food> findByIdAndRestaurantId(Long Id, Long restaurantId);
}
