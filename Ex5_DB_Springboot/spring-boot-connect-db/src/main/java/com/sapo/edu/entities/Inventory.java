package com.sapo.edu.entities;

import java.time.LocalDateTime;

import com.sapo.edu.Configs;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Inventory {

    @Id
    private int id;

    private String inventoryCode;
    private String inventoryName;
    private String location;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected Inventory() {};

    public Inventory(int id, String inventoryCode, String inventoryName, String location, String createdAt, String updatedAt){
        this.id = id;
        this.inventoryCode = inventoryCode;
        this.inventoryName = inventoryName;
        this.location = location;
        if(createdAt != null)
            this.createdAt = LocalDateTime.parse(createdAt, Configs.formatter);
        if(updatedAt != null)
            this.updatedAt = LocalDateTime.parse(updatedAt, Configs.formatter);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", inventoryCode='" + inventoryCode + '\'' +
                ", inventoryName='" + inventoryName + '\'' +
                ", location='" + location + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public int getId() {
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
