package com.pvp.eshop.service;

import com.pvp.eshop.model.Product;
import com.pvp.eshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository=productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(long id) {
        return productRepository.findById(id).get();
    }

    public Product createProduct(Product product) {
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        return productRepository.save(newProduct);
    }

    public boolean existsProduct(long id) {
        return productRepository.existsById(id);
    }

    public Product updateProduct(Long id, Product product) {
        Product productFromDb = productRepository.findById(id).get();
        productFromDb.setName(product.getName());
        productFromDb.setDescription(product.getDescription());
        productFromDb.setPrice(product.getPrice());
        return productRepository.save(productFromDb);
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}