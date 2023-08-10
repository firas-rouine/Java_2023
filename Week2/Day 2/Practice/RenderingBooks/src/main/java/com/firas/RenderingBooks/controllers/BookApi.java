package com.firas.RenderingBooks.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firas.RenderingBooks.Services.BookService;
import com.firas.RenderingBooks.models.Book;



@RestController
public class BookApi {
	
	private final BookService bookService;
	
	public BookApi(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/api/books")
	public List<Book> index() {
		
		return bookService.allBooks();
	}
	
	@RequestMapping(value = "/api/books", method = RequestMethod.POST)
	public Book create (@RequestParam("title") String title,
						@RequestParam("description") String desc,
						@RequestParam("language") String lang,
						@RequestParam("numberOfPages") int pages) {
		
		Book createdBook = new Book(title, desc, lang, pages);
		
		return bookService.createBook(createdBook);
	}
	
	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book foundBook = bookService.findBook(id);
		
		return foundBook;
	}
	   @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	    public Book update(
	    		@PathVariable("id") Long id, 
	    		@RequestParam(value="title") String title, 
	    		@RequestParam(value="description") String description, 
	    		@RequestParam(value="language") String lang,
	    		@RequestParam(value="numberOfPages") Integer numOfPages) {
	    	
	    	
	    	Book book = new Book(title, description, lang, numOfPages);
	    	book.setId(id);
	    	
	        book = bookService.updateBook(book);
	        
	        return book;
	    }
	    
	    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
	    public void destroy(@PathVariable("id") Long id) {
	    	bookService.deleteBook(id);
	    }
}