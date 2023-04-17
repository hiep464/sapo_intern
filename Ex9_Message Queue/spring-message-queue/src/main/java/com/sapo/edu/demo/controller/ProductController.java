package com.sapo.edu.demo.controller;

import com.sapo.edu.demo.dto.productdto.ProductDto;
import com.sapo.edu.demo.entities.Product;
import com.sapo.edu.demo.response.ResponseHandler;
import com.sapo.edu.demo.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "Xem danh sách sản phẩm, phân trang sản phẩm")
    @GetMapping("/products")
    public ResponseEntity<Object> getProductInPage(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "search", required = false) String keyWord){
        Page<Product> productPage = productService.getProductInPage(page, size, keyWord);
        return ResponseHandler.responseBuilder(
                "success",
                HttpStatus.OK,
                productPage
        );
    }

    @ApiOperation(value = "Xem thông tin 1 sản phẩm")
    @GetMapping("/products/{id}")
    public Product getById(@PathVariable("id") Integer id){
        return productService.getById(id);
    }

    @ApiOperation(value = "Tạo mới 1 sản phẩm")
    @PostMapping("/products")
    public Product createProduct(@Valid @RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }

    @ApiOperation(value = "Sửa thông tin sản phẩm")
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Integer id,@Valid @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @ApiOperation(value = "Thống kê 10 sản phẩm có số lượng bán nhiều nhất")
    @GetMapping("/products/statistical")
    public List<Product> statistical(){
        return productService.getProductsWithMaxSold();
    }

    @ApiOperation(value = "demo sql injection")
    @GetMapping("/sql_injection")
    public ResponseEntity<Object> sqlInjection(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "id") String id) throws SQLException {
        return ResponseHandler.responseBuilder(
                "success",
                HttpStatus.OK,
                productService.sqlInjection(name, id)
        );
    }

    @ApiOperation(value = "prevention sql injection")
    @GetMapping("/prevention")
    public ResponseEntity<Object> preventionSqlInjection(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "id") Integer id) throws SQLException {
        return ResponseHandler.responseBuilder(
                "success",
                HttpStatus.OK,
                productService.preventionSqlInjection(name, id)
        );
    }
}
