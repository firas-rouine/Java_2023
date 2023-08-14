package com.firas.DojoAndNinjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.firas.DojoAndNinjas.models.Dojo;
import com.firas.DojoAndNinjas.services.DojoService;

import jakarta.validation.Valid;
@Controller
public class DojoController {
	@Autowired
	private DojoService dojoServ;
	
	
	// DISPLAY ROUTE - FORM
		@GetMapping("/dojos/new")
		public String Dojos(@ModelAttribute("dojo") Dojo dojo, Model model) {
			
			List<Dojo> allDojo = dojoServ.allDojos();
			model.addAttribute("dojosList",allDojo);
			return "dojos/dojo.jsp";
		}
		
		// ACTION ROUTE - Create Library
		@PostMapping("/dojos/new")
		public String createDojos(@Valid @ModelAttribute("dojo") Dojo dojo,
				BindingResult res,
				Model model) {
			if(res.hasErrors()) {
				return "dojos/dojo.jsp";
			}else {
				// if there no errors
				// save
				dojoServ.createDojo(dojo);
				return "redirect:/dojos/new";
			}
		}
}
