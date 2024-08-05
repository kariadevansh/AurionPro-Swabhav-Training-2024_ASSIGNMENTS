package com.apro.assignment.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.apro.assignment.model.Book;
import com.apro.assignment.model.BookComparator;

public class BookComparatorTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Book> books = new ArrayList<Book>();
		readBooks(scanner,books);
		
		printBooks(books);
		
		
		Collections.sort(books, new BookComparator.TitleCopmarator());
		System.out.println("\nbooks sorted according to the title of the book :");
		printBooks(books);
		
		
		Collections.sort(books, new BookComparator.AuthorComparator());
		System.out.println("\nbooks sorted according to authors :");
		printBooks(books);
		
		Collections.sort(books, new BookComparator.PriceComparator());
		System.out.println("\nbooks sorted according to the price of the book :");
		printBooks(books);
		
		Collections.sort(books, new BookComparator.PublicationYearComparator());
		System.out.println("\nbooks sorted according to the publication year of the book :");
		printBooks(books);
		
		System.out.println("----------------------");
		System.out.println("Complex case 1: sorting according to the author name first, the the title and then the price :");
		Collections.sort(books,new BookComparator.AuthorComparator().thenComparing(new BookComparator.TitleCopmarator().thenComparing(new BookComparator.PriceComparator())));
		System.out.println(books);
		
		System.out.println("Complex case 2: sorting according to the publication year first, the the price and then by the author's name:");
		Collections.sort(books,new BookComparator.PublicationYearComparator().thenComparing(new BookComparator.PriceComparator().thenComparing(new BookComparator.AuthorComparator())));
		System.out.println(books);
	}
	
	private static void readBooks(Scanner scanner,List<Book> books) {
		System.out.println("Enter the number of books:");
		int n = scanner.nextInt();
		while(n>0) {
			System.out.println("\nEnter the Book name : ");
			String bookName = scanner.next();
			System.out.println("Enter the Author name : ");
			String authorName = scanner.next();
			System.out.println("Enter the price : ");
			double price = scanner.nextDouble();
			System.out.println("Enter the year of publication : ");
			int publicationYear = scanner.nextInt();
			books.add(new Book(bookName,price,authorName,publicationYear));
			n--;		
		}		
	}
	 
	private static void printBooks(List<Book> books) {
		for(Book student:books) {
			System.out.println(student);
		}
	}
}
