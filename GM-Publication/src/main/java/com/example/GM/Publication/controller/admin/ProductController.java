package com.example.GM.Publication.controller.admin;


import com.example.GM.Publication.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.GM.Publication.repository.ProductRepository;

@RestController
@RequestMapping("/api/admin/products")
@PreAuthorize("hasRole('ADMIN')")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Create a new product (Book)
     */
    @PostMapping("/add")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {

        Product savedProduct = productRepository.save(product);

        return ResponseEntity.ok(savedProduct);
    }
}