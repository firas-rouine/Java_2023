package com.firas.OmikujiForm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@RequestMapping("/omikuji")
	public String Form() {
		return "omikuji.jsp";
		
	}
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public String Process(@RequestParam("number") int number,
			@RequestParam("city") String city,@RequestParam("person") String person,
			@RequestParam("hobby") String hobby,@RequestParam("type") String type,
			@RequestParam("description") String description,HttpSession session) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("type", type);
		session.setAttribute("description", description);
		System.out.println("ggggggggggggggggggggggggggggggggggg" + number);
		return "redirect:/omikuji/show";
		
	}
	@RequestMapping("/omikuji/show")
	public String Show() {
		return "show.jsp";
		
	}


}
