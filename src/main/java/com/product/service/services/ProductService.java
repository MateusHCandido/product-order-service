package com.product.service.services;

import com.product.service.entities.Product;
import com.product.service.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository product;

    public List<Product> findAll(){
        return product.findAll();
    }

    public Product findById(Long id){
        Optional<Product> optionalProduct = product.findById(id);
        return optionalProduct.get();
    }

}
