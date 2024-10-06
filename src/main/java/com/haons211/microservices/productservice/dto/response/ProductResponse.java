package com.haons211.microservices.productservice.dto.response;

import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record ProductResponse(String id, String name, BigDecimal price) {
}
