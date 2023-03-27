package com.sapo.edu.demo.repository;

import com.sapo.edu.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("delete from Product where categoryId = ?1")
    public List<Product> deleteAllByCategoryId(Integer CategoryId);
}
