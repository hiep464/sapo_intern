package com.sapo.edu.demo.dto.productdto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductDto {

    @Id
    private int id;
    private String productCode;
    private String productName;
    private int categoryId;
    private int inventoryId;

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
}
