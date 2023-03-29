package com.sapo.edu.demo.controller;

import com.sapo.edu.demo.dto.productdto.ProductDto;
import com.sapo.edu.demo.model.Product;
import com.sapo.edu.demo.response.ResponseHandler;
import com.sapo.edu.demo.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("admin")
public class ProductController {

    @Autowired
    ProductService productService;

    @ApiOperation(value = "Xem danh sách sản phẩm")
    @GetMapping("products")
    public ResponseEntity<Object> getAll(){
        return ResponseHandler.responseBuilder(
                "success",
                HttpStatus.OK,
                productService.getAll()
        );
    }

    @ApiOperation(value = "Phân trang sản phẩm")
    @GetMapping("productsPage")
    public ResponseEntity<Object> getProductInPage(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size){
        Page<Product> productPage = productService.getProductInPage(page, size);
        return ResponseHandler.responseBuilder(
                "success",
                HttpStatus.OK,
                productPage
        );
    }

    @ApiOperation(value = "Xem thông tin 1 sản phẩm")
    @GetMapping("products/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Integer id){
        return ResponseHandler.responseBuilder(
                "success",
                HttpStatus.OK,
                productService.getById(id)
        );
    }

    @ApiOperation(value = "Tạo mới 1 sản phẩm")
    @PostMapping("products")
    public ResponseEntity<Object> createProduct(@Valid @RequestBody ProductDto productDto){
        return ResponseHandler.responseBuilder(
                "success",
                HttpStatus.OK,
                productService.createProduct(productDto)
        );
    }

    @ApiOperation(value = "Sửa thông tin sản phẩm")
    @PutMapping("products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Integer id,@Valid @RequestBody Product product){
        return ResponseHandler.responseBuilder(
                "success",
                HttpStatus.OK,
                productService.updateProduct(id, product)
        );
    }

    @ApiOperation(value = "Thống kê 10 sản phẩm có số lượng bán nhiều nhất")
    @GetMapping("products/statistical")
    public ResponseEntity<Object> statistical(){
        return ResponseHandler.responseBuilder(
                "success",
                HttpStatus.OK,
                productService.getProductsWithMaxSold()
        );
    }
}
