package com.app.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.repository.BookRepository;
import com.app.repository.MyBookRepository;
import com.app.service.Myservice;
import com.app.service.service;
import com.app.entity.*;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookDaoImpl implements service, Myservice {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	MyBookRepository myBookRepository;

	@Override
	public void save(Book book) {
		bookRepository.save(book);

	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();

	}

	@Override
	public Book getBookById(int id) {
		System.out.println(bookRepository.findById(id));
		return bookRepository.findById(id).get();
	}

	@Override
	public void deleteBook(int id) {
		bookRepository.deleteById(id);

	}

	@Override
	public void addMyBook(myBook mybook) {
		myBookRepository.save(mybook);

	}

	@Override
	public void addBook(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<myBook> getMyBooks() {
		return myBookRepository.findAll();
		
	}
	
	@Override
	public void deleteMyBook(int id) {
		myBookRepository.deleteById(id);

	}

}
