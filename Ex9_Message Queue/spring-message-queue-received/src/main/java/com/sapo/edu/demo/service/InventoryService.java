package com.sapo.edu.demo.service;

import com.sapo.edu.demo.exception.DuplicateException;
import com.sapo.edu.demo.exception.NotFoundException;
import com.sapo.edu.demo.entities.Inventory;
import com.sapo.edu.demo.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<Inventory> getAll(){
        return inventoryRepository.findAll();
    }

    public Inventory getById(Integer id){
        if(inventoryRepository.findById(id).isEmpty())
            throw new NotFoundException("Not found inventory");
        return inventoryRepository.findById(id).get();
    }

    public Inventory createInventory(Inventory inventory){
        if(inventoryRepository.findById(inventory.getId()).isEmpty())
            return inventoryRepository.save(inventory);
        throw new DuplicateException("Inventory already exist");
    }

    public Inventory updateInventory(Integer id, Inventory inventory){
        if(inventoryRepository.findById(id).isEmpty())
            throw new NotFoundException("Not found inventory");
        return inventoryRepository.save(inventory);
    }
}
