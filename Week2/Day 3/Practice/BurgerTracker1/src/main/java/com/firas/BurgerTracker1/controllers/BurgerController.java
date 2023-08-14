package com.firas.BurgerTracker1.controllers;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.firas.BurgerTracker1.models.Burger;
import com.firas.BurgerTracker1.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	@Autowired
	private BurgerService burgerService;
	
//	// DISPLAY ROUTE - READ ALL
//	@GetMapping("/")
//	public String index(Model m) {
//		List<Burger> allBurgers = burgerService.allBurgers();
//		m.addAttribute("burgerList", allBurgers);
//		return "index.jsp";
//	}
	
	// DISPLAY ROUTE - FORM
	@GetMapping("/")
	public String create(@ModelAttribute("burger") Burger burger,
						Model m) {
		List<Burger> allBurgers = burgerService.allBurgers();
		m.addAttribute("burgerList", allBurgers);
		return "index.jsp";
	}
	
	// ACTION ROUTE - Process Form
	@PostMapping("/burger")
	public String createBook(@Valid @ModelAttribute("burger") Burger burger, BindingResult result,
							Model m) {
		
		if (result.hasErrors()) {
			List<Burger> allBurgers = burgerService.allBurgers();
			m.addAttribute("burgerList", allBurgers);
			return "index.jsp";
		} else {
			// save the burger
		Burger newBurger = burgerService.createBurger(burger);

		return "redirect:/";
		}
			
		}
}
