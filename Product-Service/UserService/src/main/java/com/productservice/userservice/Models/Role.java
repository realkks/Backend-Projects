package com.productservice.userservice.Models;

import com.productservice.userservice.Models.BaseModel;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role extends BaseModel {
    private String role;
}
