package com.lutheone.dscommerce.controllers;

import com.lutheone.dscommerce.entities.Product;
import com.lutheone.dscommerce.repositories.ProductRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String test(){
        return repository.findById(1L)
                .map(Product::getName)
                .orElse("Produto não encontrado");


    }

}
