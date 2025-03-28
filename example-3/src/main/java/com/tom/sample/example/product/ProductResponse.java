package com.tom.sample.example.product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

public record ProductResponse(
        
        @Schema(
                accessMode = Schema.AccessMode.READ_ONLY,
                type = "integer",
                description = "ID único do produto",
                example = "1")
        long id,

        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "string",
                description = "Nome do produto",
                example = "Smartphone XYZ")
        String name,

        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "integer",
                description = "Quantidade do produto disponível",
                example = "5")
        int quantity,

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
        String manufacturer,

        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "boolean",
                description = "Indica se o produto está ativo",
                example = "true")
        boolean active,

        @Schema(
                accessMode = Schema.AccessMode.READ_ONLY,
                type = "string",
                format = "date-time",
                description = "Última atualização do produto",
                example = "2024-03-09T14:30:00")
        LocalDateTime lastUpdated,

        @Schema(
                accessMode = Schema.AccessMode.READ_ONLY,
                type = "string",
                format = "date-time",
                description = "Data de criação do produto",
                example = "2024-03-08T12:00:00")
        LocalDateTime dateCreated

) {
}
