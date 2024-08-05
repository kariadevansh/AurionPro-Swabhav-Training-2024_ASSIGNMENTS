package com.apro.assignments;
import java.util.Scanner;

public class WordGuesser {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] wordList = {"apple", "mango","banana","orange","airplane","elephant","remote"};
		
		String wordToGuess = wordList[(int) (Math.random()*wordList.length)];
		
		StringBuilder currentGuess = new StringBuilder();
	    for (int i = 0; i < wordToGuess.length(); i++) {
            currentGuess.append("-");
        }
	    int lives = wordToGuess.length()*3;
	    
    	System.out.println("Guess the word:\n"+currentGuess);
    	System.out.println("No.of chances left :"+lives);
	    
	    while(currentGuess.indexOf("-") != -1 && lives>0) {
	    	System.out.println("Enter your choice:");
	    	String guess = sc.next().toLowerCase();

            if (guess.length() != 1 || !Character.isLetter(guess.charAt(0))) {
                System.out.println("\nInvalid input. Please enter a single letter(you lost a chance for that.");
                lives--;
    	    	System.out.println("Current Guess :\n"+currentGuess);
    	    	System.out.println("No.of chances left :"+lives);
            }else if (wordToGuess.contains(guess)) {
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess.charAt(0)) {
                        currentGuess.setCharAt(i, guess.charAt(0));
                    }
                }
                System.out.println("\nGood guess!");
    	    	System.out.println("Current Guess :\n"+currentGuess);
    	    	System.out.println("No.of chances left :"+lives);
            } else {
                lives--;
                System.out.println("\nWrong guess!");
    	    	System.out.println("Current Guess :\n"+currentGuess);
    	    	System.out.println("No.of chances left :"+lives);
            }
	    }
	    
	    sc.close();
        if (currentGuess.indexOf("-") == -1) {
            System.out.println("\nCongratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("\nSorry, you ran out of chances. The word was: " + wordToGuess);
        }
	}
}
