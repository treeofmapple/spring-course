package com.tom.sample.example.util;

import org.springframework.context.annotation.Configuration;

import com.tom.sample.example.product.Product;

@Configuration
public class GenerateData implements DatagenUtil {

	protected Product datagen() {
		Product pro = new Product();

		pro.setName(faker.commerce().productName());

		pro.setQuantity(getRandomNumber(10, 100));

		pro.setManufacturer(faker.company().name());

		// 90 % chance
		boolean isActive = getRandomNumber(100) < 90;
		pro.setActive(isActive);

		return pro;
	}

	protected static int getRandomNumber(int min, int max) {
		return loc.nextInt(min, max);
	}

	protected static int getRandomNumber(int value) {
		return loc.nextInt(value);
	}
}


