package com.apro.assignments;


public class TimeConverter2 {
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

		int minutes = Integer.parseInt(args[0]);
		
		System.out.println("The time in Minutes is :\n"+ minutes);
		TimeConverter2 time1 = new TimeConverter2();
		time1.Converter(minutes);
	}
}
