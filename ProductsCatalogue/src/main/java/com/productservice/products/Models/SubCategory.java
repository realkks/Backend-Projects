package com.productservice.products.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SubCategory extends BaseModel{
    private String surName;
}
