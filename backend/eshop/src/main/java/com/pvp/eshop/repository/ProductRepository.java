package com.pvp.eshop.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pvp.eshop.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(
        value = "SELECT * FROM products p WHERE p.name=:name",
            nativeQuery = true
    )
    Product productByName(String name);
}