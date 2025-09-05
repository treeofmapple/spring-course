package com.tom.sample.example.product;

import java.math.BigDecimal;

public record ProductResponse(
        
        long id,
        String nome,
        int quantidade,
        BigDecimal preco,
        String fabricante,
        boolean ativo
) {
}
