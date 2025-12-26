package com.example.GM.Publication.entity;

//package com.example.GM_Publication.entity;

import com.example.GM.Publication.entity.enums.ProductType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 📘 Book Details
    @Column(nullable = false)
    private String bookName;

    @Column(nullable = false)
    private String authorName;

    // 💰 Pricing
    @Column(nullable = false)
    private BigDecimal mrpPrice;

    private BigDecimal offerPrice;

    // 🖼 Thumbnail Image
    private String thumbnailUrl;

    // 📄 PDF & Demo Content
    private String demoPdfUrl;
    private String fullPdfUrl;

    // 📦 Product Type
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    // PDF_ONLY, HARDCOPY, BOTH

    // 📚 Category Mapping
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private SubCategory subCategory;

    // 📦 Stock (for Hardcopy)
    private Integer stockQuantity;

    // ✅ Status
    private Boolean active = true;
}
