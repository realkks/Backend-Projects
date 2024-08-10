package com.productservice.products.Repositories;

import com.productservice.products.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// No need to mention repository mandatoruily annotation as inside class , it extends repository class.

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

    // for create , we have save method
    // Update is also done using save , if the product with same id exists, then it will update otherwise it will insert.
    Product save(Product p);

    // for delete , we have delete method, takes entity and return void .
    void delete(Product p);
    List<Product> findAll();

    Optional<Product> findById(Long id);
}
