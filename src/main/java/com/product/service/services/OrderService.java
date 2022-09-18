package com.product.service.services;

import com.product.service.entities.Order;
import com.product.service.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository order;

    public List<Order> findAll(){
        return order.findAll();
    }

    public Order findById(Long id){
        Optional<Order> object = order.findById(id);
        return object.get();
    }
}
