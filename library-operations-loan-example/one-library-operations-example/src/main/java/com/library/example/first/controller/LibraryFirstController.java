package com.library.example.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.library.example.first.model.Book;
import com.library.example.first.service.*;
import java.util.*;

@RestController
public class LibraryFirstController {
	
	@Autowired
	private BookService service;
	
	@GetMapping("/getbooks")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = service.getBooks();
		if (books.isEmpty()) {
			System.out.println("There are no books");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return ResponseEntity.ok().body(books);
		}
	}
	
	@PostMapping("/addbook")
	public ResponseEntity<Book> addBook(@Validated @RequestBody Book book) {
		service.addBookToDatabase(book);
		System.out.println("Added Book on Database");
		return ResponseEntity.ok().body(book);
	}
	
	@DeleteMapping("/removebook/{idBook}")
	public ResponseEntity<String> removeBook(@PathVariable long idBook) {
		boolean removed = false;
		removed = service.removeBookToDatabase(idBook);
		if(!removed) {
			System.out.println("No book founded for removing");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return ResponseEntity.ok().body("Book id " + idBook + " removed.");
		}
	}

}
