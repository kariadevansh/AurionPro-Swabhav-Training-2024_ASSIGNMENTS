package com.apro.assignment.test;

import java.util.Scanner;

import com.apro.assignment.model.PigGame;

public class PigGameRefactoredTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PigGame game = new PigGame();
        game.play(sc);
        System.out.println("\nYou finished the game in " + game.getTurns() + " turns with the score: " + game.getScore());
        System.out.println("Game Over.");
        sc.close();
    }
}