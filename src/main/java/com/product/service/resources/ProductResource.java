package com.product.service.resources;

import com.product.service.entities.Product;
import com.product.service.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = service.findAll();
        return ResponseEntity.ok().body(products);
    }

    @RequestMapping(value = "/id/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product product = service.findById(id);
        return ResponseEntity.ok().body(product);
    }

}
