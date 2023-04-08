package com.sapo.edu.demo.service;

import com.sapo.edu.demo.repository.CategoryRepository;
import com.sapo.edu.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TransactionService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Transactional
    public void deleteCategory(Integer id){
        categoryRepository.deleteById(id);
        productRepository.deleteAllByCategoryId(id);
    }
}
