package com.firas.BookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firas.BookClub.models.Book;
import com.firas.BookClub.repositories.BookRepo;

@Service
public class BookService {
	// === CRUD ===
	
	@Autowired
	private BookRepo bookRepo;
	
	// READ ALL
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	// CREATE
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}
	
	// READ ONE
	public Book findBook(Long id) {
		
		Optional<Book> maybeBook = bookRepo.findById(id);
		if(maybeBook.isPresent()) {
			return maybeBook.get();
		}else {
			return null;
		}
	}
	
	// UPDATE 
	public Book updateBook(Book b) {
		return bookRepo.save(b);
	}
	
	// DELETE
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
}
