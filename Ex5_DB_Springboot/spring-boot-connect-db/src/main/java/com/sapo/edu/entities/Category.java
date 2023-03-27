package com.sapo.edu.entities;

import com.sapo.edu.Configs;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Category{

    @Id
    private int id;

    private String categoryCode;
    private String categoryName;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected Category() {};

    public Category(int id, String categoryCode, String categoryName, String description, String createdAt, String updatedAt){
        this.id = id;
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.description = description;
        this.createdAt = LocalDateTime.parse(createdAt, Configs.formatter);
        if(updatedAt != null)
            this.updatedAt = LocalDateTime.parse(updatedAt, Configs.formatter);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryCode='" + categoryCode + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
