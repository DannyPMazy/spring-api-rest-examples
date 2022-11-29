package com.library.example.second.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.library.example.second.model.Book;
import com.library.example.second.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	public List<Book> getBooks() {
		List<Book> books = new ArrayList<>();
		repository.findAll().iterator().forEachRemaining(books::add);
		return books; 
	}
	
	public Book findBook(long idBook) {
		Book book = new Book();
		book = repository.findByIdBook(idBook);
		return book;
	}
	
	public boolean sendBookOnLoan(Book bookOnLoan) {
		boolean loanOrNot = bookOnLoan.getLoan(); 
		if (!loanOrNot) {
			bookOnLoan.setLoan(true);
			repository.save(bookOnLoan);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean returnBookFromLoan (Book bookOnLoan) {
		boolean loanOrNot = bookOnLoan.getLoan(); 
		if (loanOrNot) {
			bookOnLoan.setLoan(false);
			repository.save(bookOnLoan);
			return false;
		} else {
			return true;
		}
	}
}
