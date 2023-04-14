package com.sapo.edu.demo.repository;

import com.sapo.edu.demo.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


    List<Product> deleteAllByCategoryId(Integer id);

    List<Product> findFirst10ByOrderBySoldDesc();

    @Query("select p from Product p where upper(p.productName) like concat('%', upper(?1), '%')")
    Page<Product> findProductsByProductNameIsLike(String name, Pageable pageable);

    @Query("select p from Product p where p.productName = ?1 and p.categoryId = ?2")
    List<Product> findAllByProductNameAndCategoryId(String name, Integer id);
}
