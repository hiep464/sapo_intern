package com.sapo.edu.demo.service;

import com.sapo.edu.demo.model.Category;
import com.sapo.edu.demo.repository.CategoryRepository;
import com.sapo.edu.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Optional<Category> getById(Integer id){
        return categoryRepository.findById(id);
    }

    public Category createCategory(Category category){
        Optional<Category> category1 = categoryRepository.findById(category.getId());
        if(category1.isEmpty())
            return null;
        return categoryRepository.save(category);
    }

    public Category updateCategory(Integer id, Category category){
        Optional<Category> category1 = categoryRepository.findById(id);
        if(category1.isEmpty())
            return null;
        return categoryRepository.save(category);
    }

    @Transactional
    public void deleteCategory(Integer id){
        categoryRepository.deleteById(id);
        productRepository.deleteAllByCategoryId(id);
    }
}
