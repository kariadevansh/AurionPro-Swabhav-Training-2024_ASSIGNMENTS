package com.apro.assignments;

public class Distance2 {
public void Calculate(int x1 , int y1, int x2,int y2 ) {
		
		double distance = Math.sqrt((Math.pow((x2-x1), 2)+ Math.pow((y2-y1),2)));
		
		System.out.println("The distance between the two points: p1 ("+x1+","+y1+") & p2 ("+x2+","+y2+") is :");
		System.out.println(distance);
	}
	
	public static void main(String[] args) {
		int x1 = Integer.parseInt( args[0]);
		int y1 = Integer.parseInt( args[1]);
		System.out.println("The coordinates for first point p1: ("+x1+","+y1+")");
		
		int x2 = Integer.parseInt( args[2]);
		int y2 = Integer.parseInt( args[3]);
		System.out.println("The coordinates for second point p2: ("+x2+","+y2+")");
		
		Distance2 d = new Distance2();
		d.Calculate(x1, y1, x2, y2);
		

	}
}
