package com.apro.assignments;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Desirealization {
	public static void main(String[] args) {
		Employee e2 = null;
		String fileName = "D:\\APRO_TRAINING\\Assignment_13_7_24\\src\\com\\apro\\assignments\\test1.txt";
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			 e2 = (Employee)ois.readObject();
			 
			 fis.close();
			 ois.close();
             
			 System.out.println("Object has been deserialized ");
			 System.out.println(e2.empName);
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
