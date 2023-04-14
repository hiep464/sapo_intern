package com.sapo.edu.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table
public class Inventory {

    @Id
    Integer id;

    @NotBlank(message = "Inventory code is mandatory")
    String inventoryCode;

    @NotBlank(message = "InventoryName code is mandatory")
    String inventoryName;

    @NotBlank(message = "Location code is mandatory")
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