package com.example.GM.Publication.repository;

import com.example.GM.Publication.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
