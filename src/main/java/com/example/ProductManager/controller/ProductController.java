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
    @PostMapping("/addProduct")
    public ResponseEntity<Void> addProduct(@RequestBody ProductDto productDto){
        return productservice.addProduct(productDto);
    }
//    @PostMapping("/addProducts")

}
