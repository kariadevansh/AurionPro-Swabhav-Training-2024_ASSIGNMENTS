package com.apro.assignment.model;

public class Employee {
	public int empID;
	public String empName;
	public int empSalary;
	
	public Employee() {
		this.empID = 1000;
		this.empName = "Admin";
		this.empSalary = 100000;
	}
	public Employee(int empID, String empName, int empSalary) {
		this.empID = empID;
		this.empName =empName;
		this.empSalary = empSalary;
	}
	
	public void setEmployeeId(int empID) {
		this.empID = empID;
	}
	public void setEmployeeSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	
	public void setEmploeeName(String empName ) {
		this.empName = String.valueOf(empName);
	}
	
	public void getEmployeeId() {
		System.out.println("Employee Id : "+this.empID);
	}
	public void getEmployeeSalary() {
		System.out.println("Salary : "+ this.empSalary);	
	}
	public void getEmploeeName() {
		System.out.println("Employee Name : "+this.empName);
	}
	
	public void display() {
		getEmployeeId();
		getEmployeeSalary();
		getEmploeeName();
	}
}
