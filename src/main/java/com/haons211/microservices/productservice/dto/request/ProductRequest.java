package com.haons211.microservices.productservice.dto.request;

import java.math.BigDecimal;

public record ProductRequest(String id, String name, String description, BigDecimal price) {
}
