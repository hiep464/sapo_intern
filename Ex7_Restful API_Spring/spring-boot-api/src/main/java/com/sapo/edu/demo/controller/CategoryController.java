package com.sapo.edu.demo.controller;

import com.sapo.edu.demo.model.Category;
import com.sapo.edu.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admin")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("categories")
    public ResponseEntity<List<Category>> getAll(){
        List<Category> categories = categoryService.getAll();
        if(categories == null)
            ResponseEntity.notFound();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("categories/{id}")
    public ResponseEntity<Optional<Category>> getById(@PathVariable Integer id){
        Optional<Category> category = categoryService.getById(id);
        if(category.isEmpty())
            return (ResponseEntity<Optional<Category>>) ResponseEntity.notFound();
        return ResponseEntity.ok(category);
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category category1 = categoryService.createCategory(category);
        if(category1 == null)
            return (ResponseEntity<Category>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer id,@RequestBody Category category){
        Category category1 = categoryService.updateCategory(id, category);
        if(category1 == null)
            return (ResponseEntity<Category>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("categories/{id}")
    public ResponseEntity<String> deleteCateggory(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("ok");
    }
}
