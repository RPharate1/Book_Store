package com.app.service;

import java.util.List;

import com.app.entity.Book;



public interface service {

	public void save(Book book);
	
	public List<Book>getAllBooks();
	
	public Book getBookById(int id);
	
	public void deleteBook(int id);
	
	public void addBook(int id);

}
