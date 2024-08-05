package com.apro.assignments;

public class CompoundInterest2 {
	public void Calculate(double principal, double rate, int time) {
		double ci = principal*(Math.pow((1+rate/100), time));
		
		System.out.println("The Compound Interest is: "+ci);
	}
	public static void main(String[] args) {
		
		double principal = Double.parseDouble(args[0]);
		System.out.println("The Principal amount :"+principal);

		double rate = Double.parseDouble(args[1]);
		System.out.println("The Rate of Interest :"+rate);

		int time = Integer.parseInt(args[2]);
		System.out.println("The time peroid(years) :"+time);
		
		CompoundInterest2 ci1 = new CompoundInterest2();
		ci1.Calculate(principal, rate, time);

	}
}
