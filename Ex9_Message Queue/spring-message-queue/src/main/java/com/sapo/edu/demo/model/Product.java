package com.sapo.edu.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
public class Product {

    @Id
    private int id;

    @NotBlank(message = "Inventory code is mandatory")
    private String productCode;

    @NotNull(message = "Inventory code is mandatory")
    private int categoryId;

    @NotNull(message = "Inventory code is mandatory")
    private int inventoryId;

    @NotBlank(message = "Inventory code is mandatory")
    private String productName;

    private String description;
    private String imagePath;
    private int quantity;
    private int sold;
    private BigDecimal price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


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

    public void setId(int id) {
        this.id = id;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }



    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSold() {
        return sold;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
