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

    private String productCode;
    private int categoryId;
    private int inventoryId;
    private String productName;
    private String description;
    private String imagePath;
    private int quantity;
    private int sold;
    private BigDecimal price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected Product() {};

    public Product(int id, String productCode, int categoryId, int inventoryId, String productName,
                   String description, String imagePath, int quantity, int sold, String price,
                   String createdAt, String updatedAt){
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.categoryId = categoryId;
        this.inventoryId = inventoryId;
        this.description = description;
        this.imagePath = imagePath;
        this.quantity = quantity;
        this.sold = sold;
        this.price = new BigDecimal(price);
        if(createdAt != null)
        this.createdAt = LocalDateTime.parse(createdAt, Configs.formatter);
        if(updatedAt != null)
            this.updatedAt = LocalDateTime.parse(updatedAt, Configs.formatter);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", categoryId=" + categoryId +
                ", inventoryId=" + inventoryId +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", quantity=" + quantity +
                ", sold=" + sold +
                ", price=" + price +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
