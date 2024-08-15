package com.productservice.products.Repositories;

import com.productservice.products.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    // Implementing JPA method/query
    List<Product> findAllByCategory_SubCategory_SurNameEquals(String subCatgName);

    // Implementing JPA query according to our choices having any method name
    @Query("select p from Product p where p.category.subCategory.surName= :categorySurname")
    List<Product> bsbshbhjs(@Param("categorySurname") String categotySurname);

    //Implementing Raw query to get complex data
    @Query(
            value = CustomQuery.get_product_with_subcategory_name,
            nativeQuery = true
    )
    List<Product> raqQueryImpl();
}
