package com.apro.assignments;

import java.util.Scanner;

public class TimeConverter {
	public void Converter(int minutes) {
		int hours , mins;
		if(minutes >= 0) {
			hours = minutes/60;
			mins = minutes%60;
			System.out.println("The converted time is:");
			System.out.println(hours +" hours & "+mins+" minutes");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the time in Minutes:");
		int minutes = sc.nextInt();
		
		TimeConverter time1 = new TimeConverter();
		time1.Converter(minutes);
		sc.close();
	}

}
