package testingandcleancode;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {

	private FizzBuzz game;

	@Before
	public void before() {
		game = new FizzBuzz();
	}

	@Test
	public void should_returnNumbers_whenNotAMultipleOf3Or5() {
		List<String> numbersList = game.getNumbers();
		Assert.assertEquals("1", numbersList.get(0));
		Assert.assertEquals("2", numbersList.get(1));
		Assert.assertEquals("7", numbersList.get(6));
		Assert.assertEquals("13", numbersList.get(12));
	}

	@Test
	public void should_returnFizz_whenIsAMultipleOf3() {
		List<String> numbersList = game.getNumbers();
		Assert.assertEquals(FizzBuzz.FIZZ, numbersList.get(2));
		Assert.assertEquals(FizzBuzz.FIZZ, numbersList.get(5));
		Assert.assertEquals(FizzBuzz.FIZZ, numbersList.get(8));
		Assert.assertEquals(FizzBuzz.FIZZ, numbersList.get(11));
	}

	@Test
	public void should_returnBuzz_whenIsAMultipleOf5() {
		List<String> numbersList = game.getNumbers();
		Assert.assertEquals(FizzBuzz.BUZZ, numbersList.get(4));
		Assert.assertEquals(FizzBuzz.BUZZ, numbersList.get(9));
		Assert.assertEquals(FizzBuzz.BUZZ, numbersList.get(19));
		Assert.assertEquals(FizzBuzz.BUZZ, numbersList.get(24));
	}

	@Test
	public void should_returnFizzBuzz_whenIsAMultipleOf3And5() {
		List<String> numbersList = game.getNumbers();
		Assert.assertEquals(FizzBuzz.FIZZ + FizzBuzz.BUZZ, numbersList.get(14));
		Assert.assertEquals(FizzBuzz.FIZZ + FizzBuzz.BUZZ, numbersList.get(29));
		Assert.assertEquals(FizzBuzz.FIZZ + FizzBuzz.BUZZ, numbersList.get(59));
		Assert.assertEquals(FizzBuzz.FIZZ + FizzBuzz.BUZZ, numbersList.get(89));
	}
}
