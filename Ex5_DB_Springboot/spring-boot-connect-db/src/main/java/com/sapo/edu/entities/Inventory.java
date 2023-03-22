package com.sapo.edu.entities;

import java.time.LocalDateTime;

import com.sapo.edu.Configs;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Inventory {

    @Id
    private int id;

    private String inventory_code;
    private String inventory_name;
    private String location;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    protected Inventory() {};

    public Inventory(int id, String inventory_code, String inventory_name, String location, String created_at, String updated_at){
        this.id = id;
        this.inventory_code = inventory_code;
        this.inventory_name = inventory_name;
        this.location = location;
        if(created_at != null)
            this.created_at = LocalDateTime.parse(created_at, Configs.formatter);
        if(updated_at != null)
            this.updated_at = LocalDateTime.parse(updated_at, Configs.formatter);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", inventory_code='" + inventory_code + '\'' +
                ", inventory_name='" + inventory_name + '\'' +
                ", location='" + location + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getInventory_code() {
        return inventory_code;
    }

    public String getInventory_name() {
        return inventory_name;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }
}
