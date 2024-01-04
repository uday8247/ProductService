package com.shopping.products;

import com.shopping.products.models.Category;
import com.shopping.products.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProductsApplication.class, args);
        System.out.println("Hello");
    }

}
