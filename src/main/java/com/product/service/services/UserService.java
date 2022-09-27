package com.product.service.services;

import com.product.service.entities.User;
import com.product.service.repositories.UserRepository;
import com.product.service.services.exceptions.ResourceNotFoundException;
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
        //returning an Optional method in case an exception is thrown if the user is not found.
        return object.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    //insert user
    public User insert(User user1){
        return user.save(user1);
    }

    //delete user per id
    public void delete(Long id){
        user.deleteById(id);
    }

    //update user
    public User update(Long id, User user1){
        User entity = user.getOne(id);
        updateData(entity, user1);
        return user.save(entity);
    }

    private void updateData(User entity, User user1) {
        entity.setName(user1.getName());
        entity.setEmail(user1.getEmail());
        entity.setPhone(user1.getPhone());
    }


}
