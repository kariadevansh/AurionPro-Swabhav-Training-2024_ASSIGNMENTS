package com.apro.assignments;

import java.util.Scanner;

public class PigGame {
	
	public static int roll() {
		int randomNumber = (int) (Math.random() * 6) + 1;
		return randomNumber;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char chance;
		int die = 0;
		int turn = 0;
		int sum = 0;
		while(sum <= 20){
			System.out.println("ROLL or HOLD ? ");
			chance = sc.next().toLowerCase().charAt(0);
			switch(chance) {
			case 'r':
				die= roll();	
				System.out.println("\nDie :"+die);
				if(die !=1)
					sum += die;
				else {
					turn++;
					sum =0;
					System.out.println("Turn Over. No Score");
				}
				break;
				
			case 'h':
				turn++;
				System.out.println("\nTotal Score till now : "+sum);
				break;
				
			default:
				System.out.println("\nSelect a valid option");
				break;
			}
		}
		System.out.println("\nYou finished the game in "+turn+" turns! with the score:"+sum);
		System.out.println("Game Over.");
		sc.close();
	}
}
