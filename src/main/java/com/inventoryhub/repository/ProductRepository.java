package com.inventoryhub.repository;

import com.inventoryhub.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Basic CRUD methods are automatically provided by JpaRepository
}
