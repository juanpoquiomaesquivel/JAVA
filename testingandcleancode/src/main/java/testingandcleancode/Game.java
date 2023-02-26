package testingandcleancode;

import java.util.Random;
import java.util.Scanner;

public class Game {

	private Scanner input = new Scanner(System.in);
	private Random random = new Random();

	public void play() {
		printGameRules();
		ScoreBoard scoreboard = new ScoreBoard();
		String choice = input.nextLine().toUpperCase();

		while (!choice.equals("QUIT")) {
			GameOption choicenum = getChoiceNum(choice);

			while (choicenum == null) {
				System.out.println("Sorry, it looks like you didn't enter a correct input. Try again.");
				choice = input.nextLine().toUpperCase();
				choicenum = getChoiceNum(choice);
			}

			GameOption compnum = getChoiceComputer();
			completeGamePlay(scoreboard, choicenum, compnum);
			printResults(scoreboard);

			choice = input.nextLine().toUpperCase();
		}
	}

	private void printResults(ScoreBoard scoreboard) {
		System.out.println(
				"wins:" + scoreboard.getWins() + "\nloses:" + scoreboard.getLoses() + "\nties:" + scoreboard.getTies());
		System.out.println("Let's play again! \n \n"); // start game again
		System.out.println(
				"Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
	}

	private void completeGamePlay(ScoreBoard scoreboard, GameOption choicenum, GameOption compnum) {
		if (choicenum == compnum) // tie cases
		{
			ties(scoreboard);
		} else if (choicenum == GameOption.ROCK && compnum == GameOption.SCISSORS
				|| choicenum == GameOption.SCISSORS && compnum == GameOption.PAPER
				|| choicenum == GameOption.PAPER && compnum == GameOption.ROCK) // user wins paper vs rock
		{
			wins(scoreboard);
		} else {
			loses(scoreboard);
		}

	}

	private void ties(ScoreBoard scoreboard) {
		System.out.println("It's a tie");
		scoreboard.incrementTies();
	}

	private void loses(ScoreBoard scoreboard) {
		System.out.println("you lose.");
		scoreboard.incrementLoses();
	}

	private void wins(ScoreBoard scoreboard) {
		System.out.println("you win!");
		scoreboard.incrementWins();
	}

	private GameOption getChoiceNum(String choice) {
		GameOption selectedOption = null;

		if (choice.equals("QUIT"))
			System.exit(0);

		try {
			selectedOption = GameOption.valueOf(choice);
		} catch (Exception e) {
			return null;
		}

		return selectedOption;
	}

	private GameOption getChoiceComputer() {
		GameOption option = GameOption.values()[random.nextInt(3)];
		System.out.println("Computer chose " + option.toString().toLowerCase());

		return option;

	}

	private void printGameRules() {
		System.out.println("Let's play Rock, Paper, Scissors!");
		System.out.println(
				"Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
	}
}

// https://youtu.be/2S6Mq-ylg3k?t=4995