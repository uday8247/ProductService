package com.shopping.products.services;

import com.shopping.products.exceptions.ProductNotExistsException;
import com.shopping.products.models.Category;
import com.shopping.products.models.Product;
import com.shopping.products.repositories.CategoryRepository;
import com.shopping.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfproductservice")
//@Primary
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    private SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException {
       Optional<Product> productOptional = productRepository.findById(1L);
       if(productOptional.isEmpty()){
           throw new ProductNotExistsException("Product with id : " +id + "doesn't exist");
       }
       Product product = productOptional.get();
       return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product addNewProduct(Product product) {
        //One way of adding new Product
//        Category category = product.getCategory();
//        if(category.getId() == null){
//            Category savedCategory = categoryRepository.save(category);
//            product.setCategory(savedCategory);
//        }
//        categoryRepository.save(category);
//        return productRepository.save(product);

        Optional<Category> categoryOptional = categoryRepository.findByName(product.getCategory().getName());

        if(categoryOptional.isEmpty()){
            product.setCategory(categoryRepository.save(product.getCategory()));
        }else{
            product.setCategory(categoryOptional.get());
        }

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Void deleteProduct(Long id) {
        return null;
    }
}
