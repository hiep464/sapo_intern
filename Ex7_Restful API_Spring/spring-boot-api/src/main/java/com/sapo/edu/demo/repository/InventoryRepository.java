package com.sapo.edu.demo.repository;

import com.sapo.edu.demo.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
