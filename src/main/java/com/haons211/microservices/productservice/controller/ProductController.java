package com.haons211.microservices.productservice.controller;

import com.haons211.microservices.productservice.dto.request.ProductRequest;
import com.haons211.microservices.productservice.dto.response.ApiResponse;
import com.haons211.microservices.productservice.dto.response.ProductResponse;
import com.haons211.microservices.productservice.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Validated
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {

    ProductService productService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Void> createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
        return ApiResponse.<Void>builder()
                .code(HttpStatus.CREATED.value())
                .message("Product created successfully")
                .build();
    }

    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<List<ProductResponse>> getProducts() {
        return ApiResponse.<List<ProductResponse>>builder()
                .code(HttpStatus.OK.value())
                .message("Products retrieved successfully")
                .result(productService.getProducts())
                .build();
    }
}
