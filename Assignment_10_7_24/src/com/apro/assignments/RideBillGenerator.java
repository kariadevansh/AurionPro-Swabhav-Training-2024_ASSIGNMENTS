package com.apro.assignments;

import java.util.Scanner;

public class RideBillGenerator {
	public void generate(int height, int age ,int photos, int bill) {
		if(height>120) {
			if(age<56) {
				if(age<12) {
					bill += 5;
				}else if(age<18 && age >=12) {
					bill += 7;
				}else if(age <45 && age>=18){
					bill += 12;
				}else if(age<=55 && age>=45) {
					bill+=0;
				}
				
				if(photos == 1) {
					bill +=3;
				}
				
				System.out.println("Your total bill for the ride ticket is: $"+bill);
			}else {
				System.out.println("Sorry people above the age of 55 cant board the ride!");
			}
		}else {
			System.out.println("Sorry people of height below 120cm cant board the ride!");
		}
		

	}
	public static void main(String[] args) {
		int bill =0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the  height(in cm) and age:");
		int height = sc.nextInt();
		int age = sc.nextInt();
		System.out.println("Would you like to get yur photos clicked on the ride?\n1.Yes\n2.No Thanks");
		int photos =sc.nextInt();
		RideBillGenerator ticket1 = new RideBillGenerator();
	
		ticket1.generate(height, age, photos, bill);
		sc.close();
	}
}
