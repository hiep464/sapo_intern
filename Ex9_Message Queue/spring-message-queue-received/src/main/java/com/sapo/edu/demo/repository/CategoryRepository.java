package com.sapo.edu.demo.repository;

import com.sapo.edu.demo.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT c.categoryName, count(p.id) as products, sum(p.quantity) as number_of_products " +
            "from Product p join Category c on c.id = p.categoryId " +
            "group by c.categoryName " +
            "order by number_of_products desc")
    public List<Object> countProductInCategory();
}
