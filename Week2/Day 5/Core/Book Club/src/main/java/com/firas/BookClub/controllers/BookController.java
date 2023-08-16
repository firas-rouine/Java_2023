package com.firas.BookClub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.firas.BookClub.models.Book;
import com.firas.BookClub.models.User;
import com.firas.BookClub.services.BookService;
import com.firas.BookClub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	// Add once service is implemented:
	@Autowired
	private UserService userServ;
	@Autowired
	private BookService bookServ;

	@RequestMapping("/books")
	public String welcome(Model model, HttpSession session) {
		// grab the user id from session
		Long userId = (Long) session.getAttribute("user_id");
		// ROUTE GUARD
		if (userId == null) {
			return "redirect:/";
		} else {
			


			List<Book> allTheBooks = bookServ.allBooks();
			model.addAttribute("booksList", allTheBooks);
//			// 2. fetch the user from the DB
//			User currentUser = userServ.findOne(userId);
//			// pass the currentUser the jsp page
//			model.addAttribute("user", currentUser);

			return "welcome.jsp";
		}
	}
	
	
	
	// DISPLAY ROUTE - FORM
		@GetMapping("/books/new")
		public String create(@ModelAttribute("book") Book book,
							Model m,HttpSession session) {
			// grab the user id from session
			Long userId = (Long) session.getAttribute("user_id");
		
			// ROUTE GUARD
			if (userId == null) {
				return "redirect:/";
			} else {
			
			return "create.jsp";
		}}
		
		// ACTION ROUTE - Process Form
		@PostMapping("/books")
		public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result,
								Model m, HttpSession session) {
			
			if (result.hasErrors()) {
				return "create.jsp";
			} else {
				// save the book
			//1. grab the current user's ID from Session
			Long userID = (Long) session.getAttribute("user_id");
			//2. fetch the user from the DB
			User currentUser  = userServ.findOne(userID);
//			System.out.println(currentUser);
			//3. setAuthor to be the the current user
			book.setPoster(currentUser);
			Book newBook = bookServ.createBook(book);

			return "redirect:/books";
			}
			
		}
		
		@RequestMapping("/books/{id}")
		public String OneBook(@PathVariable("id") Long id, Model model,HttpSession session) {
			// grab the user id from session
			 Long userId = (Long) session.getAttribute("user_id");
			 // ROUTE GUARD
			 if(userId == null) {
				 return "redirect:/";
			 }else {
			Book oneBook =bookServ.findBook(id);
			model.addAttribute("oneBook",oneBook);
			
			return "oneBook.jsp";
			 }
		}
		
		// Display Route - Edit form
		@GetMapping("books/{id}/edit")
		public String editPage(@PathVariable("id") Long id, Model model, HttpSession session) {
			
			// Grab current user's id and compare it to the book's author id
			Long userID = (Long) session.getAttribute("user_id");
			// find that book with provided id
			Book thisBook = bookServ.findBook(id);
			// grab the the author's id from thisBook
			Long posterId = thisBook.getPoster().getId();
//			System.out.println("posterId " + posterId);
//			System.out.println("userID " + userID);
//			// EDIT Route Guard
//			System.out.println(userID.equals( posterId));
			if(userID.equals(posterId)) {
				model.addAttribute("book",thisBook);
				return "edit.jsp";
			}else {
			// pass thisBook to the jsp page 
			return "redirect:/books";
			
			
			}
		}
		
		// ACTION ROUTE - EDIT
		@PutMapping("/books/{id}/edit")
		public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result,
								HttpSession session,
								@PathVariable("id") Long bookID) {
			if (result.hasErrors()) {
				return "edit.jsp";
			} else {
				
				// ======== Fetch the old poster =========
				//1. grab the current user's ID from Session
				Long userID = (Long) session.getAttribute("user_id");
				//2. fetch the user from the DB
				User currentUser  = userServ.findOne(userID);
				//3. setAuthor to be the the current user
				book.setPoster(currentUser);
				// grab the book from DB
				Book thisBook = bookServ.findBook(bookID);
			
				// // if there are no errors update book
				bookServ.updateBook(book);
				return "redirect:/books";
			}
		}
		
		// DELETE
		
		@DeleteMapping("/books/{id}")
		public String delete(@PathVariable("id") Long id) {
			bookServ.deleteBook(id);
			return "redirect:/books";
		}
		
		

}
