package com.example.ProductManager.service;

import com.example.ProductManager.dao.ProductDao;
import com.example.ProductManager.dto.ProductDto;
import com.example.ProductManager.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDao productdao;


    public ResponseEntity<List<ProductDto>> getProducts() {
//        exception handling 
        List<Product> products=productdao.findAll();
        List<ProductDto> product_dtos=products.stream().map(this::MaptoProductDto).toList();
        return new ResponseEntity<>(product_dtos,HttpStatus.OK);
    }

    private ProductDto MaptoProductDto(Product product) {
    return ProductDto.builder()
            .product_id(product.getProduct_id())
            .product_name(product.getProduct_name())
            .product_price(product.getProduct_price())
            .build();
    }

    public ResponseEntity<Void> addProduct(ProductDto productDto){
        Product product= Product.builder().product_id(productDto.getProduct_id())
                .product_name(productDto.getProduct_name())
                .product_price((productDto.getProduct_price()))
                .build();
        productdao.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
