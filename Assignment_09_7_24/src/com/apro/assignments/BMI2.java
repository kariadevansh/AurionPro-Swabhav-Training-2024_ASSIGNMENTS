package com.apro.assignments;

public class BMI2 {
	public void Bmi(double weight , double height) {
		double bmi = weight/Math.pow(height,2);
		System.out.println("Your BMI is :"+ bmi);
	}
	
	public static void main(String[] args) {
	  BMI2 person1 = new BMI2();
	  double weight = Double.parseDouble( args[0]);
	  double height = Double.parseDouble( args[1]);
	  System.out.println("Your Weight is : "+ weight+ "\nYour Height is : "+ height);
	  person1.Bmi(weight, height);
}
}
