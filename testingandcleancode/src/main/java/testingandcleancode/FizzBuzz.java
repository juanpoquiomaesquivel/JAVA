package testingandcleancode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	
	public static final String FIZZ = "Fizz";
	public static final String BUZZ = "Buzz";

	public List<String> getNumbers() {
		List<String> numbers = new ArrayList<String>();

		for (int i = 1; i <= 100; i++) {
			numbers.add(getNumber(i));
		}

		return numbers;
	}

	private String getNumber(int i) {
		if (isMultiple(i, 3) && isMultiple(i, 5)) {
			return FIZZ + BUZZ;
		}

		if (isMultiple(i, 3)) {
			return FIZZ;
		}

		if (isMultiple(i, 5)) {
			return BUZZ;
		}

		return String.valueOf(i);
	}
	
	private boolean isMultiple(int number, int multiple) {
		return number % multiple == 0;
	}
}

// https://youtu.be/2S6Mq-ylg3k?t=1762