package com.sapo.edu.demo.service;

import com.sapo.edu.demo.dto.productdto.ProductDto;
import com.sapo.edu.demo.model.Product;
import com.sapo.edu.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Page<Product> getProductInPage(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage;
    }

    public Optional<Product> getById(Integer id){
        return productRepository.findById(id);
    }

    public Product generateDto(ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setProductCode(productDto.getProductCode());
        product.setProductName(productDto.getProductName());
        product.setCategoryId(productDto.getCategoryId());
        product.setInventoryId(productDto.getInventoryId());
        return product;
    }

    public Product createProduct(ProductDto productDto){
        Optional<Product> product = productRepository.findById(productDto.getId());
        if(product.isEmpty())
            return productRepository.save(generateDto(productDto));
        return null;
    }

    public Product updateProduct(Integer id, Product product){
        Optional<Product> res = productRepository.findById(id);
        if(res.isEmpty())
            return null;
        return productRepository.save(product);
    }
}
