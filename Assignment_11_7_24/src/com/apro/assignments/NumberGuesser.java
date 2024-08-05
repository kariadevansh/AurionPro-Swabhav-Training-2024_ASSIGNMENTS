package com.apro.assignments;

import java.util.Scanner;

public class NumberGuesser {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count =0;
		int guess = 0;
		int option = 0;
		boolean flag = true;
		while(flag) {
			int randomNumber = (int) (Math.random() * 100) + 1;
			System.out.println("Guess the Number: ");
			while(guess != randomNumber && count <5) {
				guess = sc.nextInt();
				if(guess>randomNumber)
					System.out.println("\nToo High, Try make your next guess a bit smaller!");
				else if(guess<randomNumber)
					System.out.println("\nToo low, Try make your next guess a bit bigger!");
				count++;
			}
			if(randomNumber == guess) {
				System.out.println("\n!!!! You guessed it!!!!");
				System.out.println("The number was :"+randomNumber);
				System.out.println("The number of guesses you took are:"+count);
			}else {
				System.out.println("\n!!!! You did not guessed it!!!!");
				System.out.println("The number was :"+randomNumber);
				System.out.println("The number of guesses you took are:"+count);
			}

			System.out.println("\nDO you want to play again ?\n1.Yes \n2.No");
			option = sc.nextInt();
			switch(option) {
			case 1:
				flag = true;
				break;
			case 2:
				flag = false;
				break;
			default :
				flag = false;
				break;
			}
		}
		System.out.println("GAME OVER");
		sc.close();
	}
}
