package com.sapo.edu.demo.repository;

import com.sapo.edu.demo.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    @Query("select i.id, i.inventoryCode, count(p.id) as  number_of_products \n" +
            "from Inventory as i left join Product  as p on i.id = p.inventoryId group by i.id")
    List<Object> thongke();
}
