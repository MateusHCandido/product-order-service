package com.product.service.repositories;

import com.product.service.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
