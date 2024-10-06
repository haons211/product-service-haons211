package com.haons211.microservices.productservice.service.impl;

import com.haons211.microservices.productservice.dto.request.ProductRequest;
import com.haons211.microservices.productservice.dto.response.ProductResponse;
import com.haons211.microservices.productservice.model.Product;
import com.haons211.microservices.productservice.repository.ProductRepository;
import com.haons211.microservices.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<ProductResponse> getProducts() {
        log.info("Get products successfully");
        return productRepository.findAll().stream().map(product -> ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build()).toList();
    }
}
