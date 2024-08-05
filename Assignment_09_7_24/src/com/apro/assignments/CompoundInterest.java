package com.apro.assignments;
import java.util.Scanner;

public class CompoundInterest {
	public void Calculate(double principal, double rate, int time) {
		double ci = principal*(Math.pow((1+rate/100), time));
		
		System.out.println("The Compound Interest is: "+ci);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Principal amount:");
		double principal = sc.nextDouble();
		
		System.out.println("Enter the Rate of Interest :");
		double rate = sc.nextDouble();
		
		System.out.println("Enter the time peroid(years):");
		int time = sc.nextInt();
		
		CompoundInterest ci1 = new CompoundInterest();
		ci1.Calculate(principal, rate, time);
		
		sc.close();
	}
}
