package com.apro.assignment.model;

public class Student {
	private int rollNo ;
	private int age;
	private double percentage ;
	private String studentName;
	
	public Student() {
		rollNo = 1;
		age = 19;
		percentage = 67.98;
		studentName =  "abc";
	}
	public Student(int r, int a, double p, String s) {
		rollNo = r;
		age = a;
		percentage = p;
		studentName =  s;
	}
	 // setter methods for each element
	public void setRollNo(int r) {
		rollNo = r;
	}
	public void setAge(int a) {
		age = a;
	}
	public void setPercentage(double p) {
		percentage = p;
	}
	
	public void setName(String n) {
		studentName = String.valueOf(n);
	}
	
	// getter methods for each element
	public void getRollNo() {
		System.out.println("Roll Number is: "+rollNo);
	}
	public void getAge() {
		System.out.println("Age is: "+age);
	}
	public void getPercentage() {
		System.out.println("Percentage is: "+percentage);
	}
	
	public void getName() {
		System.out.println("Name is: "+studentName);
	}
	
}
