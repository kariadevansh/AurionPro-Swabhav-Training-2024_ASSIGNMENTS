package com.apro.assignments;


public class AreaTrapezoid2 {
	public void Calculate(double base1, double base2, double height) {
		double area = ((base1+base2)*height)/2;
		System.out.println("The area of this Trapezoid is : "+ area);
	}
	
	public static void main(String[] args) {
		 
		  double base1 = Double.parseDouble(args[0]);
		  double base2 = Double.parseDouble(args[1]);
		  System.out.println("The measurements of the bases of the Trapezoid are base1 :"+base1+" & base2 :"+base2);
		  

		  double height = Double.parseDouble(args[2]);
		  System.out.println("The measurements of the height of the Trapezoid is :"+height);
		  
		  AreaTrapezoid area1 = new AreaTrapezoid();
		  area1.Calculate(base1, base2, height);
	}
}
