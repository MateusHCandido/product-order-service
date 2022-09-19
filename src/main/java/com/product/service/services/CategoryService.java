package com.product.service.services;

import com.product.service.entities.Category;
import com.product.service.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository category;

    public List<Category> findAll(){
         return category.findAll();
    }

    public  Category findById(Long id){
        Optional<Category> categoryOptional = category.findById(id);
        return categoryOptional.get();
    }
}
