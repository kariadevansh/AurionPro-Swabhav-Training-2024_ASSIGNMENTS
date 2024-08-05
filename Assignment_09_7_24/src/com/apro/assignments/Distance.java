package com.apro.assignments;

import java.util.Scanner;

public class Distance {
	public void Calculate(int x1 , int y1, int x2,int y2 ) {
		
		double distance = Math.sqrt((Math.pow((x2-x1), 2)+ Math.pow((y2-y1),2)));
		
		System.out.println("The distance between the two points: p1 ("+x1+","+y1+") & p2 ("+x2+","+y2+") is :");
		System.out.println(distance);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the coordinates for first point p1:");
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		
		System.out.println("Enter the coordinates for second point p2:");
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		
		Distance d = new Distance();
		d.Calculate(x1, y1, x2, y2);
		
		sc.close();
	}
}
