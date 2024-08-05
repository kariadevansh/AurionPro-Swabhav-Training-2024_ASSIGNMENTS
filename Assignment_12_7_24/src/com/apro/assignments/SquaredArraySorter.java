package com.apro.assignments;

import java.util.Scanner;

public class SquaredArraySorter {
	
	public static int[] storeAndSquareArray(int[] array, int size) {
		int[] result = new int[size];
		int left =0;
		int right =size-1;
		int index =size-1;
		
		while(left<=right) {
			int leftElement = (int)Math.pow(array[left], 2);
			int rightElement = (int)Math.pow(array[right], 2);
			if(leftElement>rightElement) {
				result[index] =leftElement;
				index--;
				left++;
				
			}else {
				result[index] =rightElement;
				index--;
				right--;
			}
			for(int i =0; i<result.length; i++) {
				System.out.println(result[i]+"\t");
			}	
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter size:");
		int size = scanner.nextInt();
		int array[] = new int[size];
		System.out.println("enter the values of array(it should be sorted)");
		for(int i =0; i<size;i++) {
			array[i] = scanner.nextInt();
		}
		
		int result[] =storeAndSquareArray(array,size);
		System.out.println(" the squared Array is :");
		for(int i =0; i<size;i++) {
			System.out.print(result[i]+"\t");
		}	
		scanner.close();
	}
}
