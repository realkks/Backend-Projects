package com.productservice.products.Repositories;

import com.productservice.products.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository <Category,Long> {

}
