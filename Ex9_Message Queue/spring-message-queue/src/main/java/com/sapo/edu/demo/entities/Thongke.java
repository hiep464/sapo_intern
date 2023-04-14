package com.sapo.edu.demo.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
@Data
public class Thongke {
    //id, mã kho, số lượng sp, ngày thống kê
    @Id
    private Integer id;

    private String inventoryCode;

    private Integer numberOfProducts;

    private LocalDateTime createdAt;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    public void setNumberOfProducts(Integer numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
