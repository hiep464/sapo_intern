package com.sapo.edu.demo.service;

import com.sapo.edu.demo.exception.DuplicateException;
import com.sapo.edu.demo.exception.NotFoundException;
import com.sapo.edu.demo.entities.Category;
import com.sapo.edu.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Category getById(Integer id){
        if(categoryRepository.findById(id).isEmpty())
            throw new NotFoundException("Not found category");
        return categoryRepository.findById(id).get();
    }

    public Category createCategory(Category category){
        if(categoryRepository.findById(category.getId()).isEmpty())
            return categoryRepository.save(category);
        else
            throw new DuplicateException("Category already exist");
    }

    public Category updateCategory(Integer id, Category category){
        if(categoryRepository.findById(id).isEmpty())
            throw new NotFoundException("Not found category");
        return categoryRepository.save(category);
    }

    public List<Object> statisticalProductsInCategory(){
        return categoryRepository.countProductInCategory();
    }
}
