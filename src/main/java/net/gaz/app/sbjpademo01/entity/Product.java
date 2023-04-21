package net.gaz.app.sbjpademo01.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(
        name = "tbl_products",
        schema = "ecommerce",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_unique",
                        columnNames = "stock_keeping_unit"
                )
        }
)

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "product_generator")

    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_sequence_name",
            allocationSize = 1
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku;

    @Column(nullable = false)
    private String name;

    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdate;
}
