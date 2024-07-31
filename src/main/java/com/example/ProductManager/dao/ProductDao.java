package com.example.ProductManager.dao;

import com.example.ProductManager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {
    @Query("SELECT p from Product p where p.product_name=:productName")
    Product findByProductName(String productName);
}
