package com.apro.assignment.test;

import java.util.Scanner;

import com.apro.assignment.model.Student;

public class StudentTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		Student s1 = new Student();
		System.out.println("Enter the Student information: \n1.Name\n2.Roll Number\n3.Age\n4.Percentage");
		String name= sc.next();
		int rollNo = sc.nextInt();
		int age = sc.nextInt();
		double percentage =sc.nextDouble();
		
		Student s1 = new Student(rollNo, age, percentage, name);  // using constructor instead of setters
//		s1.setName(name);
//		s1.setRollNo(rollNo);
//		s1.setAge(age);
//		s1.setPercentage(percentage);
		
		Student s2 = new Student();  // using default constructor
//		System.out.println("Enter the Student information: \n1.Name\n2.Roll Number\n3.Age\n4.Percentage");
//		name= sc.next();
//		rollNo = sc.nextInt();
//		age = sc.nextInt();
//		percentage =sc.nextDouble();
		
		sc.close();
		
//		s2.setName(name);
//		s2.setRollNo(rollNo);
//		s2.setAge(age);
//		s2.setPercentage(percentage);
//		
		System.out.println("Student :");
		s1.getName();
		s1.getRollNo();
		s1.getAge();
		s1.getPercentage();
		
		System.out.println("\nNext Student :");
		s2.getName();
		s2.getRollNo();
		s2.getAge();
		s2.getPercentage();
		
		
	}

}
