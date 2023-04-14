package com.sapo.edu.demo.service;

import com.sapo.edu.demo.dto.productdto.ProductDto;
import com.sapo.edu.demo.exception.DuplicateException;
import com.sapo.edu.demo.exception.NotFoundException;
import com.sapo.edu.demo.entities.Product;
import com.sapo.edu.demo.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService<id> {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductService() {
    }

    public Page<Product> getProductInPage(Integer page, Integer size, String keyWord){
        Pageable pageable = PageRequest.of(page, size);
        if(keyWord != null)
            return productRepository.findProductsByProductNameIsLike(keyWord, pageable);
        return productRepository.findAll(pageable);
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

    @Procedure
    public List<Product> getProductsWithMaxSold(){
        return productRepository.findFirst10ByOrderBySoldDesc();
    }

    private ResultSet getConnect(String sql) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ex03_mysql?useSSL=false", "root", "hiep2309");
        return connection.createStatement().executeQuery(sql);
    }

    private List<Product> generate(ResultSet rs) throws SQLException {
        List<Product> products = new ArrayList<>();
        while (rs.next()){
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setProductCode(rs.getString("product_code"));
            product.setProductName(rs.getString("product_name"));
            product.setCategoryId(rs.getInt("category_id"));
            product.setInventoryId(rs.getInt("inventory_id"));
            products.add(product);
        }
        return products;
    }

    public List<Product> sqlInjection(String name, String id) throws SQLException {
        String sql = "select * from product where product_name = " +"'"+ name + "'" + " and category_id = " + id;
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ex03_mysql?useSSL=false", "root", "hiep2309");
        ResultSet rs = connection.createStatement().executeQuery(sql);
        return generate(rs);
    }

    public List<Product> preventionSqlInjection(String name, Integer id) throws SQLException {
        return productRepository.findAllByProductNameAndCategoryId(name, id);
    }
}
