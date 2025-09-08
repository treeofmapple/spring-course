package com.tom.sample.example.produto.swagger;

import java.math.BigDecimal;

public record ProdutoResposta(
        
		/*
		 * ALERTA DE SEGURANÇA (IDOR - Insecure Direct Object Reference): *
		 * Vulnerabilidade: A exposição do ID interno permite que a API seja consultada
		 * diretamente para acessar registros marcados como inativos (soft-deleted), que
		 * deveriam estar ocultos. 
		 * 
		 * 
		 * 
		 * Cenário de Risco: Um usuário mal-intencionado pode
		 * explorar esta falha para manipular entidades inativas, como tentar adicionar
		 * um produto desativado a um carrinho de compras. Isso pode resultar em erros,
		 * inconsistência de dados ou bypass das regras de negócio.
		 * 
		 * 
		 * * Ação Corretiva: Refatorar a camada de acesso a dados (Repository/Service)
		 * para garantir que todos os endpoints públicos filtrem e retornem
		 * exclusivamente registros com status 'ativo'.
		 * 
		 */
		
        Long id,
        String nome,
        Integer quantidade,
        BigDecimal preco,
        String fabricante,
        Boolean ativo
        
        
) {
}
