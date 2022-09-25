package com.product.service.services;

import com.product.service.entities.User;
import com.product.service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository user;

    public List<User> findAll(){
        return user.findAll();
    }

    public User findById(Long id){
        Optional<User> object = user.findById(id);
        return object.get();
    }

    public User insert(User user1){
        return user.save(user1);
    }
}
