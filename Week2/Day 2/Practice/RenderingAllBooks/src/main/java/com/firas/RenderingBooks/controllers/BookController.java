package com.firas.RenderingBooks.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.firas.RenderingBooks.Services.BookService;
import com.firas.RenderingBooks.models.Book;

@Controller
public class BookController {
	
	// import the bookService
	private final BookService bookService;
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	

	@RequestMapping("/books/{id}")
	public String showOne(@PathVariable("id") Long id,
					Model model) {
		
		// fetch the book from DB
		Book thisBook = bookService.findBook(id);
		
		// pass the book the jsp page
		model.addAttribute("book",thisBook);
		
		return "show.jsp";
	}
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "index.jsp";
    }
}
