package com.apro.assignment.model;

import java.util.Scanner;

public class PigGame {
	private static final int WINNING_SCORE = 20;
	private int score;
	private int turns;
	private final Die die;

	public PigGame() {
		this.score = 0;
		this.turns = 0;
		this.die = new Die();
	}

	public void play(Scanner sc) {
		while (score <= PigGame.WINNING_SCORE) {
			takeTurn(sc);
		}
	}

	private void takeTurn(Scanner sc) {
		System.out.println("ROLL or HOLD? ");
		char choice = sc.next().toLowerCase().charAt(0);

		switch (choice) {
		case 'r':
			rollDie();
			break;

		case 'h':
			hold();
			break;

		default:
			System.out.println("\nSelect a valid option");
			break;
		}
	}

	private void rollDie() {
		int roll = die.roll();
		System.out.println("\nDie: " + roll);

		if (roll != 1) {
			score += roll;
		} else {
			score = 0;
			turns++;
			System.out.println("Turn Over. No Score");
		}
	}

	private void hold() {
		turns++;
		System.out.println("\nTotal Score till now: " + score);
	}

	public int getScore() {
		return score;
	}

	public int getTurns() {
		return turns;
	}

}

class Die {
	public int roll() {
		return (int) (Math.random() * 6) + 1;
	}
}
