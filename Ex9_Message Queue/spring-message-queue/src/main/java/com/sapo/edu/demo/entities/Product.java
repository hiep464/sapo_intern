package com.sapo.edu.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
public class Product extends BaseEntity{

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
}
