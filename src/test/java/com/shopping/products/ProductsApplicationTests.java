package com.shopping.products;

import com.shopping.products.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.beans.Transient;

@SpringBootTest
class ProductsApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    @Commit
    void testQueries(){
//        productRepository.findByTitleContaining("uday");
//        productRepository.deleteByTitle("uday");
    }
}
