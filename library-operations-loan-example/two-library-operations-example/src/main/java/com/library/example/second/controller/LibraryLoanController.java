package com.library.example.second.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.example.second.model.Book;
import com.library.example.second.service.*;

@RestController
public class LibraryLoanController {
	
	@Autowired
	private BookService service;
	
	@PutMapping("/sendloan/{idBook}")
	public ResponseEntity<String> sendBookOnLoan(@PathVariable long idBook) {
		Book book = new Book();
		book = service.findBook(idBook);
		if(book == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		boolean loanOrNot = service.sendBookOnLoan(book);
		if(loanOrNot) {
			return ResponseEntity.ok().body("Book sended on Loan\n" + book);
		} else {
			return ResponseEntity.ok().body("Book is already on Loan\n" + book);
		}
	}
	
	@PutMapping("/returnloan/{idBook}")
	public ResponseEntity<String> returnBookOnLoan(@PathVariable long idBook) {
		Book book = new Book();
		book = service.findBook(idBook);
		if(book == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		boolean loanOrNot = service.returnBookFromLoan(book);
		if(!loanOrNot) {
			return ResponseEntity.ok().body("Book returned to Library\n" + book);
		} else {
			return ResponseEntity.ok().body("Book is already on Library\n" + book);
		}
	}

}
