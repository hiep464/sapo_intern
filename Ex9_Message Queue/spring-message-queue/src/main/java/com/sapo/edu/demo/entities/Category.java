package com.sapo.edu.demo.entities;

import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table
@ApiModel(value = "Category model")
public class Category extends BaseEntity{

    @NotBlank(message = "CategoryCode is mandatory")
    String categoryCode;

    @NotBlank(message = "CategoryName is mandatory")
    String categoryName;

    String description;

    public String getCategoryCode() {
        return categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
