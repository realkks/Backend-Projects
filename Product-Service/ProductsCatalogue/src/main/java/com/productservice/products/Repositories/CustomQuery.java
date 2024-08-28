package com.productservice.products.Repositories;

// This class will include all the details of Custom queries used in the project
public interface CustomQuery {
    String get_product_with_subcategory_name =
            "SELECT * From product p JOIN category c ON p.category_id = c.id JOIN sub_category s ON c.sub_category_id = s.id";
}
