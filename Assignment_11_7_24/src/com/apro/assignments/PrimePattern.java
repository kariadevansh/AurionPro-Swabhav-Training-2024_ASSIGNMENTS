package com.apro.assignments;

import java.util.Scanner;
public class PrimePattern {	
	static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no.of line:");
		int rows= sc.nextInt();
		int num = 2;
        for (int i = 1; i <= rows; i++){
        	for (int j = 1; j <= i; j++) {
                while (!isPrime(num)) {
                    num++;
                }
                System.out.print(num + "\t");
                num++;
            }
            System.out.println();
        }
        sc.close();
	}
}
