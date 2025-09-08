package com.tom.sample.example.produto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductNameRequest(
		
        @NotNull(message = "O nome não pode ser nulo")
        @NotBlank(message = "O nome não pode estar em branco")
        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "string",
                description = "Nome do produto",
                example = "Smartphone XYZ")
		String name
		) {
}
