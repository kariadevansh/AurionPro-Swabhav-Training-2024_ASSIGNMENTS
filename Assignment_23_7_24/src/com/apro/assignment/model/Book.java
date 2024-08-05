package com.apro.assignment.model;

public class Book {
	
	private String bookName;
	private double bookPrice;
	private String authorName;
	private int publicationYear;
	
	
public Book(String bookName, double bookPrice, String authorName, int publicationYear) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.authorName = authorName;
		this.publicationYear = publicationYear;
	}

	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	@Override
	public String toString() {
		return "BookStore [bookName=" + bookName + ", bookPrice=" + bookPrice + ", authorName=" + authorName
				+ ", publicationYear=" + publicationYear + "]";
	}

	
}
