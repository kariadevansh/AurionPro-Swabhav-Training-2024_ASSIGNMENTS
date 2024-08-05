package com.apro.assignments;

import java.util.Scanner;

public class AreaTrapezoid {
	
	public void Calculate(double base1, double base2, double height) {
		double area = ((base1+base2)*height)/2;
		System.out.println("The area of this Trapezoid is : "+ area);
	}
	
	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
		  System.out.println("Enter the measurements of the bases of the Trapezoid :");
		  double base1 = sc.nextInt();
		  double base2 = sc.nextInt();
		  
		  System.out.println("Enter the measurements of the height of the Trapezoid :");
		  double height = sc.nextInt();
		  
		  AreaTrapezoid area1 = new AreaTrapezoid();
		  area1.Calculate(base1, base2, height);
	}

}
