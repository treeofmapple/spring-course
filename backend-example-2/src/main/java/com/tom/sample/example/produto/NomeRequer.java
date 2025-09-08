package com.tom.sample.example.produto;

import jakarta.validation.constraints.NotBlank;

public record NomeRequer(
		
        @NotBlank(message = "O nome não pode estar em branco")
		String nome
		) {
}
