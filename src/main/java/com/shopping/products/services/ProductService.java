package com.shopping.products.services;

import com.shopping.products.exceptions.ProductNotExistsException;
import com.shopping.products.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id) throws ProductNotExistsException;

    List<Product> getAllProducts();

    Product replaceProduct(Long id,Product product);

    Product addNewProduct(Product product);

    Product updateProduct(Long id,Product product) throws ProductNotExistsException;

    Void deleteProduct(Long id);

}
