package com.apro.assignment.test;

import java.util.Scanner;

import com.apro.assignment.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("No.of employees ?");
		int n =sc.nextInt();
		Employee employees[] = new Employee[n];
		for(int i =0;i<n;i++) {
			System.out.println("\nEnter the Employee information: \n1.Name\n2.Employee ID\n3.Salary");
			String name= sc.next();
			int id = sc.nextInt();
			int salary = sc.nextInt();
			employees[i] = new Employee(id,name,salary);
		}
		sc.close(); 
			
		for (int i =0;i<n;i++) {
			System.out.println("Employee details "+ i+" :");
			employees[i].display();
		}
	
	}

}
