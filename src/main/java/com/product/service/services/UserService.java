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


    //list all users
    public List<User> findAll(){
        return user.findAll();
    }

    //search user per id
    public User findById(Long id){
        Optional<User> object = user.findById(id);
        return object.get();
    }

    //insert user
    public User insert(User user1){
        return user.save(user1);
    }

    //delete user per id
    public void delete(Long id){
        user.deleteById(id);
    }
}
