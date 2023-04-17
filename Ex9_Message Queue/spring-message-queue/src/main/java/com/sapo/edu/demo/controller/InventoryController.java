package com.sapo.edu.demo.controller;

import com.sapo.edu.demo.entities.Inventory;
import com.sapo.edu.demo.service.InventoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("admin")
public class InventoryController {

    InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @ApiOperation(value = "Xem danh sách kho")
    @GetMapping("/inventories")
    public List<Inventory> getAll(){
        return inventoryService.getAll();
    }

    @ApiOperation(value = "Xem thông tin 1 kho")
    @GetMapping("/inventories/{id}")
    public Inventory getById(@PathVariable Integer id){
        return inventoryService.getById(id);
    }

    @ApiOperation(value = "Thêm mới 1 kho")
    @PostMapping("/inventories")
    public Inventory createInventory(@Valid @RequestBody Inventory inventory){
        return inventoryService.createInventory(inventory);
    }

    @ApiOperation(value = "Sửa thông tin kho")
    @PutMapping("/inventories/{id}")
    public Inventory updateInventory(@PathVariable Integer id,@Valid @RequestBody Inventory inventory){
        return inventoryService.updateInventory(id, inventory);
    }
}
