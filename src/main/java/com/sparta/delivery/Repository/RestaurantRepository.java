package com.sparta.delivery.Repository;

import com.sparta.delivery.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
//    Optional<Restaurant> findByName(String name);
//    List<Restaurant> findAll(
    Optional <Restaurant> findById(Long id);


}
