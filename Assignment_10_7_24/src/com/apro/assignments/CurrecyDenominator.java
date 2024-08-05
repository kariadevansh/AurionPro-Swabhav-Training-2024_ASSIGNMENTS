package com.apro.assignments;

import java.util.Scanner;

public class CurrecyDenominator {
	public void denominate(int amount) {
		int count_2000, count_500, count_200, count_100;
		if(amount%100 ==0 && amount <=50000 && amount > 0) {
				count_2000 = amount/2000;
				amount%= 2000;
				
				count_500 = amount/500;
				amount %= 500;
				
				count_200 = amount/200;
				amount %=200;
				
				count_100 = amount/100;
				
				System.out.println("The denominations are:");
				if(count_2000>0) {
					System.out.println("Two Thousand : "+ count_2000);
				}

				if(count_500>0) {
					System.out.println("Five Hundred : "+ count_500);
				}
				if(count_200>0) {
					System.out.println("Two Hundred : "+ count_200);
				}
				if(count_100>0) {
					System.out.println("One Hundred : "+ count_100);
				}
		}else if(amount>50000){
			System.out.println("Amount exceeds withdrawal limit of 50000!");
		}
		else {
			System.out.println("Enter a valid amount! Amount should be in multiples of 100!");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the  withdrawal amount:");
		int amount = sc.nextInt();
		
		CurrecyDenominator ob1 = new CurrecyDenominator();
		
		ob1.denominate(amount);
		sc.close();
	}

}
