package com.apro.assignment2.test;

import java.util.Scanner;
import com.apro.assignment2.model.LoginCredentials;
import com.apro.assignment2.model.MailIdValidityException;
import com.apro.assignment2.model.PasswordValidityException;

public class LoginCredentialsTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LoginCredentials newUser = new LoginCredentials();
		try {
			System.out.println("Enter your mailID");
			String mailId =scanner.next();
			newUser.setMailId(mailId);
			newUser.vaildateMailId(mailId);
			
			System.out.println("Create a password");
			String password =scanner.next();
			newUser.setPassword(password);
			newUser.validatePassword(password);
			
			System.out.println(newUser);
			
			
		}catch(MailIdValidityException exception) {
			System.out.println(exception.getMessage());
		}catch(PasswordValidityException exception){
			System.out.println(exception.getMessage());
		}
		
	}
}
