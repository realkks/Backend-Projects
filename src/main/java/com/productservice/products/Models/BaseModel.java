package com.productservice.products.Models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//This class act as Base model class which contains common attributes

@Getter
@Setter
@MappedSuperclass
// Spring doen't know about inheritance and inheriting the attributes from parent to child class
// This annotation helps to tell springs ,
// whatever are the attributes of this class, put all attributes in corresponding child class
//No need to create table for this class
public class BaseModel {
    @Id                 // It will tell spring to consider id as primary key
    private Long id;
    private Date createdAt;
    private Date updatedAt;
    private Boolean isDeleted;
}
