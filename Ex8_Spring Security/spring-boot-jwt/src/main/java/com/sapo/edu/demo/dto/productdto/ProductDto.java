package com.sapo.edu.demo.dto.productdto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class ProductDto {

    @Id
    @NotNull(message = "ID not null")
    private int id;

    @NotBlank(message = "ProductCode code is mandatory")
    private String productCode;

    @NotBlank(message = "ProductName code is mandatory")
    private String productName;

    @NotNull(message = "CategoryId code is mandatory")
    private int categoryId;

    @NotNull(message = "InventoryId code is mandatory")
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
