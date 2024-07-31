package com.example.ProductManager.controller;

import com.example.ProductManager.dto.ProductDto;
import com.example.ProductManager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productservice;
    @GetMapping("/getProducts")
    public ResponseEntity<List<ProductDto>> getProducts(){
        return productservice.getProducts();
    }
    @PostMapping("/getProduct")
    public ResponseEntity<ProductDto> getProduct(@RequestParam String product_name){
        return productservice.getProduct(product_name);
        
    }
//    add a single product to the database
    @PostMapping("/addProduct")
    public ResponseEntity<Void> addProduct(@RequestBody ProductDto productDto){
        return productservice.addProduct(productDto);
    }
//    add products from a list of json.
    @PostMapping("/addProducts")
    public ResponseEntity<Void> addProducts(@RequestBody List<ProductDto> productDtos){
        return productservice.addProducts(productDtos);
    }
    
}
