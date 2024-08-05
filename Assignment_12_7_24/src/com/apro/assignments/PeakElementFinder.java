package com.apro.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PeakElementFinder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array:");
		int size = sc.nextInt();
		int array[] = new int[size];
		System.out.println("enter the values of array:");
		for(int i =0; i<size;i++) {
			array[i] = sc.nextInt();
		}
		sc.close();
//		int[] peaks = new int[size];
		ArrayList<Integer> peak = new ArrayList<>();
		
		for(int i=0; i<size; i++) {
			if(i == 0) {
				if(array[i] >= array[i+1]) { // its the 1st element so we only compare it with  the right one
//					peaks[i] = array[i];
					peak.add(array[i]);
				}
			}else if(0<i && i<size-1) {
				if(array[i] >= array[i-1] && array[i] >= array[i+1]) { // middle elements so we compare it with both left and right ones
//					peaks[i] = array[i];
					peak.add(array[i]);
				}
			}else {
				if(array[i] >= array[i-1]) {// its the last element so we compare it with only the left one
//					peaks[i] = array[i];
					peak.add(array[i]);
				}
			}
//			System.out.println(array[i]);
//			System.out.println(peak);
		}
		
		System.out.println(peak);
		
//		System.out.println(Arrays.toString(peaks));
		
	}
}
