package com.tom.sample.example.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductRequest(
		
        @NotNull(message = "O nome não pode ser nulo")
        @NotBlank(message = "O nome não pode estar em branco")
        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "string",
                description = "Nome do produto",
                example = "Smartphone XYZ")
        String name,

        @NotNull(message = "A quantidade não pode ser nula")
        @Size(min = 1, max = 10, message = "O minimo é 1 o máximo é 10")
        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "integer",
                description = "Quantidade do produto em estoque",
                example = "5")
        int quantity,

        @NotNull(message = "O preço não pode ser nulo")
        @Positive(message = "O preço deve ser maior que zero")
        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "number",
                format = "decimal",
                description = "Preço do produto",
                example = "999.99")
        BigDecimal price,

        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "string",
                description = "Nome do fabricante do produto",
                example = "Apple")
        String manufacturer
){
	
}
