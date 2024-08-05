package com.apro.assignment.model;

import java.util.Comparator;

public class BookComparator {
	public static class TitleCopmarator implements Comparator<Book>{
		@Override
		public int compare(Book book1, Book book2) {
			return book1.getBookName().compareToIgnoreCase(book2.getBookName());
		}	
	}
	
	public static class AuthorComparator implements Comparator<Book>{
		@Override
		public int compare(Book book1, Book book2) {
			return book1.getAuthorName().compareToIgnoreCase(book2.getAuthorName());
		}
	}
	public static class PriceComparator implements Comparator<Book>{
		@Override
		public int compare(Book book1, Book book2) {
			return (int) (book1.getBookPrice()- book2.getBookPrice());
		}
	}
	public static class PublicationYearComparator implements Comparator<Book>{
		@Override
		public int compare(Book book1, Book book2) {
			return (int) (book1.getPublicationYear() - book2.getPublicationYear());
		}
	}
}
