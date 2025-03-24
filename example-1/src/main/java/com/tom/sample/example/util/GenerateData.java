package com.tom.sample.example.util;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.context.annotation.Configuration;

import com.tom.sample.example.model.Livros;

@Configuration
public class GenerateData implements DatagenUtil {

	protected Livros datagen() {
		Livros pro = new Livros();

		pro.setId(atomicCounter.incrementAndGet());

		pro.setTitle(faker.book().title());

		pro.setAuthor(faker.book().author());

		boolean data = getRandomNumber(100) < 90;

		if (data) {
			pro.setBookDate(generatePastDate(5,12));
		} else {
			pro.setBookDate(generatePastDate(12,30));
		}

		return pro;
	}

	protected LocalDate generatePastDate(int minDays, int maxDays) {
		LocalDate today = LocalDate.now();
		LocalDate pastDate = today.minusYears(getRandomNumber(minDays, maxDays));
		return LocalDate.from(pastDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	protected LocalDate generateFutureDate(int years) {
		LocalDate today = LocalDate.now();
		LocalDate futureDay = today.plusYears(years);
		return LocalDate.from(futureDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	protected static int getRandomNumber(int min, int max) {
		return loc.nextInt(min, max);
	}

	protected static int getRandomNumber(int value) {
		return loc.nextInt(value);
	}
}
