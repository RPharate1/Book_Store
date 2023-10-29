package com.app.service;

import java.util.List;

import com.app.entity.*;

public interface Myservice {

	public void addMyBook(myBook mybook);

	public List<myBook> getMyBooks();
	
	public void deleteMyBook(int id);

}
