package com.sapo.edu.demo.controller;

import com.sapo.edu.demo.model.Inventory;
import com.sapo.edu.demo.response.ResponseHandler;
import com.sapo.edu.demo.service.InventoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("admin")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @ApiOperation(value = "Xem danh sách kho")
    @GetMapping("inventories")
    public ResponseEntity<Object> getAll(){
        return ResponseHandler.responseBuilder(
                "success",
                HttpStatus.OK,
                inventoryService.getAll()
        );
    }

    @ApiOperation(value = "Xem thông tin 1 kho")
    @GetMapping("inventories/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id){
        return ResponseHandler.responseBuilder(
                "success",
                HttpStatus.OK,
                inventoryService.getById(id)
        );
    }

    @ApiOperation(value = "Thêm mới 1 kho")
    @PostMapping("inventories")
    public ResponseEntity<Object> createInventory(@Valid @RequestBody Inventory inventory){
        return ResponseHandler.responseBuilder(
                "success",
                HttpStatus.OK,
                inventoryService.createInventory(inventory)
        );
    }

    @ApiOperation(value = "Sửa thông tin kho")
    @PutMapping("inventories/{id}")
    public ResponseEntity<Object> updateInventory(@PathVariable Integer id,@Valid @RequestBody Inventory inventory){
        return ResponseHandler.responseBuilder(
                "success",
                HttpStatus.OK,
                inventoryService.updateInventory(id, inventory)
        );
    }
}
