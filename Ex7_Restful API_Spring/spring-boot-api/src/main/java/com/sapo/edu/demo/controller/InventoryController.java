package com.sapo.edu.demo.controller;

import com.sapo.edu.demo.model.Inventory;
import com.sapo.edu.demo.service.InventoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admin")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @ApiOperation(value = "Xem danh sách kho")
    @GetMapping("inventories")
    public ResponseEntity<List<Inventory>> getAll(){
        List<Inventory> inventories = inventoryService.getAll();
        if(inventories == null)
            return (ResponseEntity<List<Inventory>>) ResponseEntity.notFound();
        return ResponseEntity.ok(inventories);
    }

    @ApiOperation(value = "Xem thông tin 1 kho")
    @GetMapping("inventories/{id}")
    public ResponseEntity<Optional<Inventory>> getById(@PathVariable Integer id){
        Optional<Inventory> inventory = inventoryService.getById(id);
        return ResponseEntity.ok(inventory);
    }

    @ApiOperation(value = "Thêm mới 1 kho")
    @PostMapping("inventories")
    public ResponseEntity<Inventory> createInventory(@Valid @RequestBody Inventory inventory){
        Inventory inventory1 = inventoryService.createInventory(inventory);
        if(inventory1 == null)
            return (ResponseEntity<Inventory>) ResponseEntity.notFound();
        return ResponseEntity.ok(inventory1);
    }

    @ApiOperation(value = "Sửa thông tin kho")
    @PutMapping("inventories/{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable Integer id,@Valid @RequestBody Inventory inventory){
        Inventory inventory1 = inventoryService.updateInventory(id, inventory);
        if(inventory1 == null)
            return (ResponseEntity<Inventory>) ResponseEntity.notFound();
        return ResponseEntity.ok(inventory);
    }
}
