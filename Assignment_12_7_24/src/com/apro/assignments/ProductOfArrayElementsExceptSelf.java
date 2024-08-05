package com.apro.assignments;

import java.util.Scanner;

public class ProductOfArrayElementsExceptSelf {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        scanner.close();

        int[] prod = getProductArray(array);

        System.out.print("prod[] = ");
        for (int number : prod) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static int[] getProductArray(int[] array) {
        int n = array.length;
        int[] prod = new int[n];

        if (n < 2) {
            return prod;
        }

        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];

        leftProduct[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProduct[i] = leftProduct[i - 1] * array[i - 1];
        }

        rightProduct[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * array[i + 1];
        }

        for (int i = 0; i < n; i++) {
            prod[i] = leftProduct[i] * rightProduct[i];
        }

        return prod;
    }
}

