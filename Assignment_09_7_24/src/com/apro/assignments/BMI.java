package com.apro.assignments;

import java.util.Scanner;

public class BMI {
	
	public void Bmi(double weight , double height) {
		double bmi = weight/Math.pow(height,2);
		System.out.println("Your BMI is :"+ bmi);
	}
	
	public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  BMI person1 = new BMI();
	  System.out.println("Enter the body weight(kgs) & height (m):");
	  double weight = sc.nextDouble();
	  double height = sc.nextDouble();
	
	  person1.Bmi(weight, height);
	  sc.close();
}
}
