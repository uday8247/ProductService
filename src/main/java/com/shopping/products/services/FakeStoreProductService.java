package com.shopping.products.services;

import com.shopping.products.dtos.FakeStoreProductDto;
import com.shopping.products.exceptions.ProductNotExistsException;
import com.shopping.products.models.Category;
import com.shopping.products.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    private final RestTemplate restTemplate;
    HashMap<Long,FakeStoreProductDto> map = new HashMap<>();

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product=new Product();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setId(fakeStoreProductDto.getId());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());

        return product;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException {
        FakeStoreProductDto productDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);

        if(productDto==null){
            throw new ProductNotExistsException(
                    "product with id: " + id + "doesn't exist."
            );
        }
        return convertFakeStoreProductToProduct(productDto);
    }

    @Override
    public List<Product> getAllProducts() {

        FakeStoreProductDto[] response = restTemplate.getForObject(
               "https://fakestoreapi.com/products",FakeStoreProductDto[].class);

        List<Product> answer = new ArrayList<>();
        for(FakeStoreProductDto dto:response){
            answer.add(convertFakeStoreProductToProduct(dto));
        }

        return answer;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {

//        RequestCallback requestCallback = restTemplate.httpEntityCallback(new FakeStoreProductDto(),FakeStoreProductDto.class);
//        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor =
//                new HttpMessageConverterExtractor<>(FakeStoreProductDto.class,restTemplate.getMessageConverters());
//        FakeStoreProductDto response = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT,
//                requestCallback,responseExtractor);
//
//        return convertFakeStoreProductToProduct(response);

        map.remove(id);
        FakeStoreProductDto dto = new FakeStoreProductDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        dto.setCategory(product.getCategory().toString());
        dto.setImage(product.getImageUrl());
        map.put(id,dto);
        return product;

    }

    @Override
    public Product addNewProduct(Product product) {

        FakeStoreProductDto dto = new FakeStoreProductDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setImage(product.getImageUrl());
        dto.setCategory(product.getCategory().toString());

        map.put(product.getId(),dto);

        return product;

    }

    @Override
    public Void deleteProduct(Long id) {
        map.remove(id);
        return null;
    }

}
