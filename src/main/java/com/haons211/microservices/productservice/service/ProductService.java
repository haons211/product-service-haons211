package com.haons211.microservices.productservice.service;

import com.haons211.microservices.productservice.dto.request.ProductRequest;

public interface ProductService {

    void createProduct(ProductRequest productRequest);

}
