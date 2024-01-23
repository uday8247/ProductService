package com.shopping.products.repositories;

import com.shopping.products.models.Category;
import com.shopping.products.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
//    List<Product> findByTitleContaining(String word);
//
//    long deleteByTitle(String title);
//
//    List<Product> findByTitleAndDescription(String title,String description);
//
//    List<Product> findByPriceBetween(double start,double end);
//
//    List<Product> findByCategory(Category category);
//
//    Product findByIdAndCategory(Long id,Category category);
//
//    Product findByIdAndCategoryOrderByTitle(Long id,Category category);
//
//    //finding all the products with a category id
//    List<Product> findByCategory_Id(Long id);

    //This will return a null if there is no id,so use optional in order
    // to avoid null pointer exception if the id is null
    Optional<Product> findById(Long id);

    //add
    Product save(Product product);
}
