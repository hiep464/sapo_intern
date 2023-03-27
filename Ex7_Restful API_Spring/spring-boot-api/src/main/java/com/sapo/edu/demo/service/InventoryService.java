package com.sapo.edu.demo.service;

import com.sapo.edu.demo.model.Inventory;
import com.sapo.edu.demo.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    public List<Inventory> getAll(){
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getById(Integer id){
        return inventoryRepository.findById(id);
    }

    public Inventory createInventory(Inventory inventory){
        Optional<Inventory> inventory1 = inventoryRepository.findById(inventory.getId());
        if(inventory1.isEmpty())
            return null;
        return inventoryRepository.save(inventory);
    }

    public Inventory updateInventory(Integer id, Inventory inventory){
        Optional<Inventory> res = inventoryRepository.findById(id);
        if(res.isEmpty())
            return  null;
        return inventoryRepository.save(inventory);
    }
}
