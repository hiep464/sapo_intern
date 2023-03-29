package com.sapo.edu.demo.service;

import com.sapo.edu.demo.dto.productdto.ProductDto;
import com.sapo.edu.demo.exception.DuplicateException;
import com.sapo.edu.demo.exception.NotFoundException;
import com.sapo.edu.demo.model.Product;
import com.sapo.edu.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Product getById(Integer id){
        if(productRepository.findById(id).isEmpty())
            throw new NotFoundException("Not found product");
        return productRepository.findById(id).get();
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
        if(productRepository.findById(productDto.getId()).isEmpty())
            return productRepository.save(generateDto(productDto));
        throw new DuplicateException("Product already exist");
    }

    public Product updateProduct(Integer id, Product product){
        if(productRepository.findById(id).isEmpty())
            throw new NotFoundException("Not found product");
        return productRepository.save(product);
    }
}
