package com.sparta.delivery.Repository;

import com.sparta.delivery.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
