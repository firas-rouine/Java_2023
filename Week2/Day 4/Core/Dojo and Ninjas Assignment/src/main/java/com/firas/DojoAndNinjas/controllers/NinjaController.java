package com.firas.DojoAndNinjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.firas.DojoAndNinjas.models.Dojo;
import com.firas.DojoAndNinjas.models.Ninja;
import com.firas.DojoAndNinjas.services.DojoService;
import com.firas.DojoAndNinjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	@Autowired
	private NinjaService ninjaService;
	@Autowired
	private DojoService dojoService;
	


	
	// DISPLAY ROUTE - FORM
	@GetMapping("/ninjas/new")
	public String create(@ModelAttribute("ninja") Ninja ninja,
						Model m) {
		List<Dojo> allDojos = dojoService.allDojos();
		m.addAttribute("dojoList", allDojos);
		return "ninjas/ninja.jsp";
	}
	
	// ACTION ROUTE - Process Form
	@PostMapping("/ninjas/new")
	public String createBook(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result,
							Model m) {
		
		if (result.hasErrors()) {
			return "ninjas/ninja.jsp";
		} else {
			// save the burger
		Ninja newNinja = ninjaService.createNinja(ninja);

		Long dojoId = newNinja.getDojo().getId(); 

        return "redirect:/dojos/" + dojoId; 
		}
			
		}
	@GetMapping("/dojos/{id}")
	public String allNinjasDojo(@PathVariable("id") Long id, Model model) {
	    Dojo dojo = dojoService.findDojo(id);
	    List<Ninja> ninjas = dojoService.findAllNinjasInDojo(id);
	    
	    model.addAttribute("dojo", dojo);
	    model.addAttribute("ninjas", ninjas);
	    
	    return "ninjas/allNinjas.jsp";
	}

	
	
		
}
