package com.apro.assignments;

import java.util.Scanner;

public class StringCharacterShifter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String:");
		String string =sc.next();
		System.out.println("by what positions you want to shift the characters?");
		int shift = sc.nextInt();
		sc.close();
		char[] charArray = string.toCharArray();
		   for (int i = 0; i < charArray.length; i++) {
	            if (Character.isLowerCase(charArray[i])) {
	            	charArray[i] = (char) ('a' + (charArray[i] - 'a' + shift) % 26);
	            } else if (Character.isUpperCase(charArray[i])) {
	            	charArray[i] = (char) ('A' + (charArray[i] - 'A' + shift) % 26);
	            }
	        }
		 String result = new String(charArray);
		 System.out.println("After shifting we get: "+result);
		 
	}
}
