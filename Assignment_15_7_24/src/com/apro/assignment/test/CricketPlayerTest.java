package com.apro.assignment.test;

import java.util.Scanner;

import com.apro.assignment.model.CricketPlayer;

public class CricketPlayerTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CricketPlayer players[] = new CricketPlayer[11];
		players[0]= new CricketPlayer();
		System.out.println("plyaer 1: \n");
		players[0].display();
		System.out.println("Avg runs of player 1:" );
		players[0].avgRuns();
		
		System.out.println("\nAvg wickets of player 1:" );
		players[0].avgWickets();
//		System.out.println("\nEnter details of player 2:\n1.Id\n2.Name\n3.No.of matcher\n4.total runs\n5.no.of wickets");
//		int id = scanner.nextInt();
//		String name = scanner.next();
//		int matches = scanner.nextInt();
//		int runs = scanner.nextInt();
//		int wickets = scanner.nextInt();
//		players[1]= new CricketPlayer(id,name,matches,runs,wickets);
//		players[1].display();
		
		for(int i =0;i<11;i++) {
			System.out.println("\nEnter details of player:\n1.Id\n2.Name\n3.No.of matcher\n4.total runs\n5.no.of wickets");
			int id = scanner.nextInt();
			String name = scanner.next();
			int matches = scanner.nextInt();
			int runs = scanner.nextInt();
			int wickets = scanner.nextInt();
			players[i]= new CricketPlayer(id,name,matches,runs,wickets);
		}
		
		for(int i =0;i<11;i++) {
			System.out.println("For player :"+i);
			players[i].display();
			System.out.println("Avg runs :" );
			players[i].avgRuns();
			System.out.println("Avg wickets :" );
			players[i].avgWickets();
			
		}
		
//		System.out.println("Avg runs of player 2:" + c2.avgRuns(runs, matches));
//		System.out.println("Avg wickets of player 2:" + c2.avgWickets(wickets, matches));
	}

}
