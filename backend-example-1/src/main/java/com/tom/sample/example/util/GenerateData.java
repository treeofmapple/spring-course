package com.tom.sample.example.util;

import java.time.LocalDate;

import org.springframework.context.annotation.Configuration;

import com.tom.sample.example.model.Livros;

@Configuration
public class GenerateData implements DatagenUtil {

	protected Livros datagen() {
		Livros pro = new Livros();

		String uniqueName = generateUniqueProductName();
		pro.setTitle(uniqueName);

		pro.setAuthor(faker.book().author());

		boolean data = getRandomNumber(100) < 90;

		if (data) {
			pro.setBookDate(generatePastDate(5,12));
		} else {
			pro.setBookDate(generatePastDate(12,30));
		}

		return pro;
	}
	
    private String generateUniqueProductName() {
        String name;
        do {
            name = faker.book().title();
        } while (generatedNames.contains(name));

        generatedNames.add(name);
        return name;
    }

	protected LocalDate generatePastDate(int minDays, int maxDays) {
		LocalDate today = LocalDate.now();
		LocalDate pastDate = today.minusYears(getRandomNumber(minDays, maxDays));
		return pastDate;
	}

	protected LocalDate generateFutureDate(int years) {
		LocalDate today = LocalDate.now();
		LocalDate futureDay = today.plusYears(years);
		return futureDay;
	}

	protected int getRandomNumber(int min, int max) {
		return loc.nextInt(min, max);
	}

	protected int getRandomNumber(int value) {
		return loc.nextInt(value);
	}
}
