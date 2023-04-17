package com.sapo.edu.demo.controller;

import com.sapo.edu.demo.entities.Category;
import com.sapo.edu.demo.response.ResponseHandler;
import com.sapo.edu.demo.service.CategoryService;
import com.sapo.edu.demo.service.TransactionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("CategoryController")
@RequestMapping("/admin")
public class CategoryController {

    CategoryService categoryService;

    TransactionService transactionService;

    public CategoryController(CategoryService categoryService, TransactionService transactionService) {
        this.categoryService = categoryService;
        this.transactionService = transactionService;
    }

    @ApiOperation(value = "Xem danh sách loại sản phẩm")
    @GetMapping("/categories")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @ApiOperation(value = "Xem 1 loại sản phẩm")
    @GetMapping("/categories/{id}")
    public Category getById(@PathVariable Integer id){
        return categoryService.getById(id);
    }

    @ApiOperation(value = "Tạo mới 1 loại sản phẩm")
    @PostMapping("/categories")
    public Category createCategory(@Valid @RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @ApiOperation(value = "Sửa thông tin 1 loại sản phẩm")
    @PutMapping("/categories/{id}")
    public Category updateCategory(@PathVariable Integer id,@Valid @RequestBody Category category){
        return categoryService.updateCategory(id, category);
    }

    @ApiOperation(value = "Xóa 1 lại sản phẩm đồng thời xóa sản phẩm thuộc danh mục sản phẩm đó")
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Object> deleteCateggory(@PathVariable Integer id){
        transactionService.deleteCategory(id);
        return ResponseHandler.responseBuilder(
                "success",
                HttpStatus.OK,
                null
        );
    }

    @ApiOperation(value = "Đếm số lượng sản phẩm trong mỗi loại danh mục, sắp xếp theo thứ tự giảm dần")
    @GetMapping("/product-in-category")
    public List<Object> statisticalProductsInCategory(){
        return categoryService.statisticalProductsInCategory();
    }
}
