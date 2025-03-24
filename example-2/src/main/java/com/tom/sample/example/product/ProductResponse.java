package com.tom.sample.example.product;

import java.math.BigDecimal;

public record ProductResponse(
        
        long id,
        String name,
        int quantity,
        BigDecimal price,
        String manufacturer,
        boolean active
) {
}
