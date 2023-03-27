package com.sapo.edu.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
public class Inventory {

    @Id
    Integer id;
    String inventoryCode;
    String inventoryName;
    String location;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public Integer getId() {
        return id;
    }

    public String getInventoryCode() {
        return inventoryCode;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}