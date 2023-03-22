package com.sapo.edu.entities;

import com.sapo.edu.Configs;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Product {
    @Id
    private int id;

    private String product_code;
    private int category_id;
    private int inventory_id;
    private String product_name;
    private String description;
    private String image_path;
    private int quantity;
    private int sold;
    private BigDecimal price;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    protected Product() {};

    public Product(int id, String product_code, int category_id, int inventory_id, String product_name,
                   String description, String image_path, int quantity, int sold, String price,
                   String created_at, String updated_at){
        this.id = id;
        this.product_code = product_code;
        this.product_name = product_name;
        this.category_id = category_id;
        this.inventory_id = inventory_id;
        this.description = description;
        this.image_path = image_path;
        this.quantity = quantity;
        this.sold = sold;
        this.price = new BigDecimal(price);
        this.created_at = LocalDateTime.parse(created_at, Configs.formatter);
        if(updated_at != null)
            this.updated_at = LocalDateTime.parse(updated_at, Configs.formatter);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product_code='" + product_code + '\'' +
                ", category_id=" + category_id +
                ", inventory_id=" + inventory_id +
                ", product_name='" + product_name + '\'' +
                ", description='" + description + '\'' +
                ", image_path='" + image_path + '\'' +
                ", quantity=" + quantity +
                ", sold=" + sold +
                ", price=" + price +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
