package com.example.spring_boot_whiskey.controller;

import com.example.spring_boot_whiskey.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user-products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<String> getProducts() {
        return productService.getProducts();
    }

}
