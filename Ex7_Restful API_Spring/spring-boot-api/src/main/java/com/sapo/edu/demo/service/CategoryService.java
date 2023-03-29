package com.sapo.edu.demo.service;

import com.sapo.edu.demo.exception.DuplicateException;
import com.sapo.edu.demo.exception.NotFoundException;
import com.sapo.edu.demo.model.Category;
import com.sapo.edu.demo.repository.CategoryRepository;
import com.sapo.edu.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

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

    @Transactional
    public void deleteCategory(Integer id){
        categoryRepository.deleteById(id);
        productRepository.deleteAllByCategoryId(id);
    }
}
