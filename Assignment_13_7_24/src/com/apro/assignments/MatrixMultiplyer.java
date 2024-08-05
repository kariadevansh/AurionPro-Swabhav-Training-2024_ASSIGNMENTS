package com.apro.assignments;

import java.util.Scanner;

public class MatrixMultiplyer {
	public static int[][] readMatrix(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the no.of rows and columns::");
		int rows = scanner.nextInt();
		int columns = scanner.nextInt();
		int matrix[][] = new int[rows][columns];
		
		System.out.println("Enter the elements :");
		for(int i =0;i<rows;i++) {
			for(int j =0;j<columns;j++) {
				matrix[i][j]= scanner.nextInt();
			}
		}
		scanner.close();
		return matrix;
	}
	
	public static void multiplyMatrix(int matrix1[][], int matrix2[][]){
		int result[][] =  new int[matrix1.length][matrix2[0].length]; // dimensions of result = m1 x n2 (rows of matrix1 x columns of matrix2)
		if (matrix1[0].length != matrix2.length) {   // can only multiply if columns of matrix1 = rows of matrix2
            System.out.println("Matrices have different dimensions. Cannot perform multiplication.");
        }else {
            for (int i = 0; i < matrix1.length; i++) {  // iterating over each row of 1st martix
                for (int j = 0; j < matrix2[0].length; j++) {  // iterating over each row of 1st martix
                	for(int k =0;k<matrix1[0].length ; k++) // iterating over each row of 1st martix
                		
                		result[i][j] += matrix1[i][k]*matrix2[k][j];    // here we multiply each element of the rows of matrix1 
                										               // 	with each element of the columns of matrix2 
                			//  for each iteration and add the values together for no.of times = no.of columns of matrix1 or no.of rows of matrix2
                }
            }
            System.out.println("Result of matrix multiplication:");
            printMatrix(result);
        }
		
	}
	
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
	public static void main(String[] args) {

		System.out.println("Enter the dimensions of the first matrix:");
		int matrix1[][]= readMatrix();
		
		System.out.println("Enter the dimensions of the second matrix:");
		int matrix2[][]= readMatrix();
		
		multiplyMatrix(matrix1,matrix2);
		
	}
}
