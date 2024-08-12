package com.productservice.products.Repositories;

import com.productservice.products.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository <Category,Long> {
    Optional<Category> findByName(String name); //Optional means , return value will never be null
    Category save(Category category);   // Saving the category

}
