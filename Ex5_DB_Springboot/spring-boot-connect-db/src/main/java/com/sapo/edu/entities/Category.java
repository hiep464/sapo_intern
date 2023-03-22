package com.sapo.edu.entities;

import com.sapo.edu.Configs;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Category{

    @Id
    private int id;

    private String category_code;
    private String category_name;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    protected Category() {};

    public Category(int id, String category_code, String category_name, String description, String created_at, String updated_at){
        this.id = id;
        this.category_code = category_code;
        this.category_name = category_name;
        this.description = description;
        this.created_at = LocalDateTime.parse(created_at, Configs.formatter);
        if(updated_at != null)
            this.updated_at = LocalDateTime.parse(updated_at, Configs.formatter);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category_code='" + category_code + '\'' +
                ", category_name='" + category_name + '\'' +
                ", description='" + description + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
