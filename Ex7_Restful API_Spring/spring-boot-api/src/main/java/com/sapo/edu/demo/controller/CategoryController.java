package com.sapo.edu.demo.controller;

import com.sapo.edu.demo.model.Category;
import com.sapo.edu.demo.response.ResponseHandler;
import com.sapo.edu.demo.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("CategoryController")
@RequestMapping("admin")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @ApiOperation(value = "Xem danh sách loại sản phẩm")
    @GetMapping("categories")
    public ResponseEntity<Object> getAll(){
        return ResponseHandler.responseBuilder(
                "success",
                HttpStatus.OK,
                categoryService.getAll()
        );
    }

    @ApiOperation(value = "Xem 1 loại sản phẩm")
    @GetMapping("categories/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        Category category = categoryService.getById(id);
        return ResponseHandler.responseBuilder("success",HttpStatus.OK,category);
    }

    @ApiOperation(value = "Tạo mới 1 loại sản phẩm")
    @PostMapping("/categories")
    public ResponseEntity<Object> createCategory(@Valid @RequestBody Category category){
        return ResponseHandler.responseBuilder(
                "success",
                HttpStatus.OK,
                categoryService.createCategory(category)
        );
    }

    @ApiOperation(value = "Sửa thông tin 1 loại sản phẩm")
    @PutMapping("/categories/{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable Integer id,@Valid @RequestBody Category category){
        return ResponseHandler.responseBuilder(
                "success",
                HttpStatus.OK,
                categoryService.updateCategory(id, category)
        );
    }

    @ApiOperation(value = "Xóa 1 lại sản phẩm đồng thời xóa sản phẩm thuộc danh mục sản phẩm đó")
    @DeleteMapping("categories/{id}")
    public ResponseEntity<Object> deleteCateggory(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return ResponseHandler.responseBuilder(
                "success",
                HttpStatus.OK,
                null
        );
    }
}
