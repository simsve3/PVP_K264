package com.pvp.eshop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long Id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Description is mandatory")
    @Column(name = "description", nullable = false)
    private String description;

    @NotBlank(message = "Price is mandatory")
    @Column(name = "price", nullable = false)
    private float price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private User created_by;
}