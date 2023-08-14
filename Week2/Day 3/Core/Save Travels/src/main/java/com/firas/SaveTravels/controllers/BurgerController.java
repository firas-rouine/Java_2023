package com.firas.SaveTravels.controllers;

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

import com.firas.SaveTravels.models.Travel;
import com.firas.SaveTravels.services.TravelService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	@Autowired
	private TravelService Service;
	

	@GetMapping("/expenses/{id}")
	public String showOne(@PathVariable("id") Long id,
					Model model) {
		
		
		Travel travel = Service.findTravel(id);
		
		
		model.addAttribute("travel",travel);
		
		return "oneTravel.jsp";
	}
	
	// DISPLAY ROUTE - FORM
	@GetMapping("/expenses")
	public String create(@ModelAttribute("travel") Travel travel,
						Model m) {
		List<Travel> allTravels = Service.allTravels();
		m.addAttribute("travelList", allTravels);
		return "index.jsp";
	}
	
	// ACTION ROUTE - Process Form
	@PostMapping("/expenses")
	public String createBook(@Valid @ModelAttribute("travel") Travel travel, BindingResult result,
							Model m) {
		
		if (result.hasErrors()) {
			List<Travel> allTravels = Service.allTravels();
			m.addAttribute("travelList", allTravels);
			return "index.jsp";
		} else {
			// save the burger
		Travel newTravel = Service.createTravel(travel);

		return "redirect:/expenses";
		}
			
		}
	
	// Display Route - Edit form
	
		@GetMapping("expenses/edit/{id}")
		public String editPage(@PathVariable("id") Long id, Model model) {
			
			
			Travel travel = Service.findTravel(id);
			
			model.addAttribute("travel",travel);
			
			return "edit.jsp";
		}
		
		@PutMapping("expenses/edit/{id}")
		public String updateTravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
			if (result.hasErrors()) {
				return "edit.jsp";
			} else {
				// if there are no errors update 
				Service.updateTravel(travel);
				return "redirect:/expenses";
			}
		}
		// DELETE
		
		@DeleteMapping("/expenses/{id}")
		public String delete(@PathVariable("id") Long id) {
			Service.deleteTravel(id);
			return "redirect:/expenses";
		}
		
}
