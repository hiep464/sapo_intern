package com.sapo.edu.demo.service;

import com.sapo.edu.demo.repository.CategoryRepository;
import com.sapo.edu.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TransactionService {

    CategoryRepository categoryRepository;

    ProductRepository productRepository;

    public TransactionService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public void deleteCategory(Integer id){
        categoryRepository.deleteById(id);
        productRepository.deleteAllByCategoryId(id);
    }
}
