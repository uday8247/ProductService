package com.shopping.products.services;

import com.shopping.products.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id);

    List<Product> getAllProducts();

    Product replaceProduct(Long id,Product product);
}
