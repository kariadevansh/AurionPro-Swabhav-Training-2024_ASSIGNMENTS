package com.apro.assignments;
import java.util.Scanner;

public class SecondLargestElementFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        if (n < 2) {
            System.out.println("Array must have at least two elements.");
            return;
        }

        int[] array = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        scanner.close();

        int secondLargest = getSecondLargestNumber(array);
        System.out.println("Second largest element in the array: " + secondLargest);
    }

    public static int getSecondLargestNumber(int[] array) {
        int first = 0; // Largest element
        int second = 0; // Second largest element

        for (int number : array) {
            if (number > first) {
                second = first;
                first = number;
            } else if (number > second && number != first) {
                second = number;
            }
        }

        return second;
    }
}
