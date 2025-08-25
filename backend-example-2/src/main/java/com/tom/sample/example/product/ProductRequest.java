package com.tom.sample.example.product;

import java.math.BigDecimal;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ProductRequest(
		
        @NotBlank(message = "O nome não pode estar em branco")
        String name,

        @Max(value = 1000, message = "O minimo é 1 o máximo é 1000")
        int quantity,

        @Positive(message = "O preço deve ser maior que zero")
        BigDecimal price,
        
        String manufacturer
){

}
