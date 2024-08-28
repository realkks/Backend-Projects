package com.productservice.userservice.Models;

import com.productservice.userservice.Models.BaseModel;
import com.productservice.userservice.Models.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class User extends BaseModel {
    private String password;
    private String email;
    private String phone;
    private String fullName;
    @ManyToMany (fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

}
