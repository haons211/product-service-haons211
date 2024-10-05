package com.haons211.microservices.productservice.service.impl;

import com.haons211.microservices.productservice.dto.request.ProductRequest;
import com.haons211.microservices.productservice.model.Product;
import com.haons211.microservices.productservice.repository.ProductRepository;
import com.haons211.microservices.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Override
    public void createProduct(ProductRequest productRequest) {

        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        log.info("Create product successfully: {}", product);
    }
}
