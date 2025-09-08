package com.tom.sample.example.produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProdutoResponse(
        
        Long id,
        String name,

		/*
		 * A escolha entre um tipo primitivo (int, long) e sua classe wrapper (Integer,
		 * Long) tem implicações diretas na flexibilidade e segurança do seu código.
		 * 
		 * Porque o int não pode representar um valor nulo. Seu valor padrão é 0.
		 * 
		 * Enquanto o Integer pode ser nulo
		 * 
		 * Performance o int é mais rápido.
		 * 
		 */
        
        Integer quantity,
        
		/*
		 * Tipos double e float são tipos de ponto flutuante binário (padrão IEEE 754).
		 * Isso significa que eles não conseguem representar com precisão todos os
		 * números decimais. Assim como a fração 1/3 vira uma dízima periódica em base
		 * 10 (0.333...), a fração 1/10 (ou 0.1) vira uma dízima periódica em base 2
		 * (binário).
		 * 
		 * Isso causa pequenos erros de arredondamento que são catastróficos para
		 * cálculos financeiros.
		 * 
		 */
        
        BigDecimal price,
        
        
        String manufacturer,
        Boolean active,
        LocalDateTime lastUpdated,
        LocalDateTime dateCreated
) {
}
