package com.lutheone.dscommerce.services;

import com.lutheone.dscommerce.dto.ProductDTO;
import com.lutheone.dscommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        return repository.findById(id)
                .map(ProductDTO::new)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

    }

}
