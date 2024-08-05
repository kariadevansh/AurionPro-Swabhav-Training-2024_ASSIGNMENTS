package com.apro.assignments;
import java.util.Scanner;

public class TreasureHunt {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("!!!!Welcome to the Treasure Island!!!!!\n YOUR MISSION IS TO FIND THE TREASURE");
		System.out.println("You are at a cross road, which way do you go?\n1.Left \n2.Right");
		int direction = sc.nextInt();
		if(direction == 1) {
			System.out.println("You stumble across a weird lake Their is an old temple in the Middle of this lake, what will you do?");
			System.out.println("\n1.Swim to the other \n2.Wait at the edge");
			int decision = sc.nextInt();
			if(decision == 2) {
				System.out.println("A bridge appeared and you reached the temple");
				System.out.println("Inside the temple you see 3 doors , behind one is the treasure\nMake the final call wisely");
				System.out.println("1.RED \n2.BLUE \n3.Yellow");
				int door = sc.nextInt();
				if(door == 1) {
					System.out.println("You opened the RED door. \n The room you entired got up in flames and you got Burned by the fire");
					System.out.println("!!!!GAME OVER!!!!");
				}else if (door == 2) {
					System.out.println("You opened the BLUE door. \nThe room you entired was full of beasts and you just became their Lunch");
					System.out.println("!!!!GAME OVER!!!!");
				}else if(door == 3) {
					System.out.println("You opened the YEllOW door.\nThe room you entired is filled with gold coins, jewls and treasures from around the globe");
					System.out.println("!!!!YOU WON!!!!");
				}else {
					System.out.println("!!!!GAME OVER!!!!");
				}
			}else {
				System.out.println("Your tried to swim but a trout attacked you and took you to the depths of the lake \n!!!!GAME OVER!!!!");
			}
		}else {
			System.out.println("YOU FELL INTO A HOLE! \n!!!!GAME OVER!!!!");
		}
		sc.close();
	}
}
