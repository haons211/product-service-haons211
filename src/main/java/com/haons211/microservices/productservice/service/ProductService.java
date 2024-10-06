package com.haons211.microservices.productservice.service;

import com.haons211.microservices.productservice.dto.request.ProductRequest;
import com.haons211.microservices.productservice.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {

    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getProducts();
}
