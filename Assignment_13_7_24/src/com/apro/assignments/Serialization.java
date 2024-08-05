package com.apro.assignments;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serialization{
	public static void main(String[] args) {
			Employee e1 = new Employee();
			e1.empID = 7081;
			e1.empName =" devansh";
			e1.empDepartment ="banking";
			
			String fileName = "D:\\APRO_TRAINING\\Assignment_13_7_24\\src\\com\\apro\\assignments\\test1.txt";
			try {
				FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				oos.writeObject(e1);
				
				fos.close();
	            oos.close();
	             
	            System.out.println("Object has been serialized");
	 
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
