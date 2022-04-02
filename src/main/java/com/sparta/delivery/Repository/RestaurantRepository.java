package com.sparta.delivery.Repository;

import com.sparta.delivery.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
//    Optional<Restaurant> findByName(String name);
//    List<Restaurant> findAll();

}
