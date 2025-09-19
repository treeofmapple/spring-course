package com.tom.sample.example.util;

import java.math.BigDecimal;

import org.springframework.context.annotation.Configuration;

import com.tom.sample.example.produto.Produto;

@Configuration
public class GenerateData implements DatagenUtil {

	protected Produto datagen() {
		Produto pro = new Produto();

        String uniqueName = generateUniqueProductName();
        pro.setNome(uniqueName);

		pro.setQuantidade(getRandomInt(10, 1000));

		pro.setPreco(BigDecimal.valueOf(getRandomDouble(10, 120)));
		
		pro.setFabricante(faker.company().name());

		// 90 % chance
		boolean isActive = getRandomNumber(100) < 90;
		pro.setAtivo(isActive);

		return pro;
	}
	
    private String generateUniqueProductName() {
        String name;
        do {
            name = faker.commerce().productName();
        } while (generatedNames.contains(name));

        generatedNames.add(name);
        return name;
    }
	
	protected double getRandomDouble(int min, int max) {
		return loc.nextDouble(min, max);
	}

	protected int getRandomInt(int min, int max) {
		return loc.nextInt(min, max);
	}

	protected int getRandomNumber(int value) {
		return loc.nextInt(value);
	}
}


