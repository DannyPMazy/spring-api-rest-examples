package com.library.example.first.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.library.example.first.repository.BookRepository;
import com.library.example.first.model.Book;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	public List<Book> getBooks() {
		List<Book> books = new ArrayList<>();
		repository.findAll().iterator().forEachRemaining(books::add);
		return books; 
	}
	
	public void addBookToDatabase(Book book) {
		repository.save(book);
	}
	
	public boolean removeBookToDatabase(long idBook) {
		Book founded = repository.findByIdBook(idBook);
		if (founded == null) {
			System.out.println("There is no product to delete");
			return false;
		} else {
			repository.delete(founded);
			return true;
		}
	}
	
}
