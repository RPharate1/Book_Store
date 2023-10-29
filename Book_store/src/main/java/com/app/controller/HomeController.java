package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.entity.Book;
import com.app.entity.myBook;
import com.app.service.Myservice;
import com.app.service.service;

@Controller
public class HomeController {

	@Autowired
	service bookservice;

	@Autowired
	Myservice myservice;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Book book, Model map) {
		bookservice.save(book);
		map.addAttribute("book", bookservice.getAllBooks());
		return "booklist";
	}

	@GetMapping("/available_books")
	public String availableBooks(Model map) {
		map.addAttribute("book", bookservice.getAllBooks());
		return "bookList";
	}
	
	@GetMapping("/mylist/available_books")
	public String availableBooks1(Model map) {
		map.addAttribute("book", bookservice.getAllBooks());
		return "bookList";
	}

	@GetMapping("/editBook/{id}")
	public String editBook(@PathVariable int id, Model map) {
		map.addAttribute("book", bookservice.getBookById(id));
		return "bookEdit";
	}

	@GetMapping("/deleteBook/{id}")
	public String deletetBook(@PathVariable int id) {
		bookservice.deleteBook(id);
		return "redirect:/available_books";

	}

	@GetMapping("mylist/{id}")
	public String addBook(@PathVariable int id, Model map) {
		Book b = bookservice.getBookById(id);

		myBook mybook = new myBook(b.getId(), b.getName(), b.getAuthor(), b.getPrice());

		myservice.addMyBook(mybook);

		map.addAttribute("book", myservice.getMyBooks());
		return "myBooks";
	}
	
	@GetMapping("/my_books")
	public String getMyBooks(Model map) {
		map.addAttribute("book", myservice.getMyBooks());
		return "myBooks";
	}
	
	@GetMapping("/deleteMyList/{id}")
	public String deletetMyBook(@PathVariable int id) {
		myservice.deleteMyBook(id);
		return "redirect:/my_books";

	}

}
