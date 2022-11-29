package com.library.example.second.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.example.second.model.Book;

@Repository

public interface BookRepository extends CrudRepository<Book, Long> {
	
	public Book findByIdBook(long idBook);

}
