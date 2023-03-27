package com.sapo.edu.demo.controller;

import com.sapo.edu.demo.dto.productdto.ProductDto;
import com.sapo.edu.demo.model.Product;
import com.sapo.edu.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admin")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("products")
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = productService.getAll();
        if(products == null)
            return (ResponseEntity<List<Product>>) ResponseEntity.notFound();
        return ResponseEntity.ok(products);
    }

    @GetMapping("productsPage")
    public ResponseEntity<Page<Product>> getProductInPage(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size){
        Page<Product> productPage = productService.getProductInPage(page, size);
        return ResponseEntity.ok(productPage);
    }

    @GetMapping("products/{id}")
    public ResponseEntity<Optional<Product>> getById(@PathVariable("id") Integer id){
        Optional<Product> product = productService.getById(id);
        if(product.isEmpty())
            return (ResponseEntity<Optional<Product>>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(product);
    }

    @PostMapping("products")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto){
        Product product = productService.createProduct(productDto);
        if(product == null)
            return (ResponseEntity<Product>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(product);
    }

    @PutMapping("products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product){
        Product res = productService.updateProduct(id, product);
        if(res == null)
            return (ResponseEntity<Product>) ResponseEntity.notFound();
        return ResponseEntity.ok(res);
    }
}
