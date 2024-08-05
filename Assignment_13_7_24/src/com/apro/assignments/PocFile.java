package com.apro.assignments;

import java.io.File;
import java.util.Scanner;

public class PocFile {
	public static void fileFunctions(String fname) {
	
 
        // pass the filename or directory name to File
        // object
        File f = new File(fname);
 
        // apply File class methods on File object
        System.out.println("Exists : " + f.exists());    // Tests whether the file or directory denoted by this abstract pathname exists.
        System.out.println("File name : " + f.getName());  // it fetches the name of the file
        System.out.println("Path: " + f.getPath()); // it fetches the path of the file
        System.out.println("Absolute path : "+ f.getAbsolutePath());  // Returns the absolute pathname string of this abstract pathname.
        System.out.println("Parent : " + f.getParent());  //Returns the pathname string of this abstract pathname’s parent.
        
 
        if (f.exists()) {
            System.out.println("Is writable : "+ f.canWrite());
            System.out.println("Is readable : " + f.canRead());
            System.out.println("Is a directory : "+ f.isDirectory());
            System.out.println("File Size in bytes : "+ f.length());
        }
	}
	public static void main(String[] args) {
		System.out.println("Enter the file name or directory name:");
		Scanner sc = new Scanner(System.in);
        String fname = sc.next();
        sc.close();
		fileFunctions(fname);
	}
}
