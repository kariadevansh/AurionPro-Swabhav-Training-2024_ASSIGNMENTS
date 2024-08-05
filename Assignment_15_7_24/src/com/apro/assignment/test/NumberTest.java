package com.apro.assignment.test;
import com.apro.assignment.model.Number;
import java.util.Scanner;

public class NumberTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter any 2 numbers :");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		Number number1 = new Number(n1);
		Number number2 = new Number(n2);
		
		System.out.println("Before swapping : number 1: "+number1.getValue() + " number 2: "+number2.getValue());
		swap(number1,number2);
		System.out.println("\nAfter swapping : number 1: "+number1.getValue() + " number 2: "+number2.getValue());
		
	}
	
	private static void swap(Number number1, Number number2) {
		int temp = number1.getValue();
		number1.setValue(number2.getValue());
		number2.setValue(temp);
	}

}
