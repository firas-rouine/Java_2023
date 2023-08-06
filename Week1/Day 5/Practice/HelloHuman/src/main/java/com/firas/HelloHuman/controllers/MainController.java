package com.firas.HelloHuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@RequestMapping("/")
	public String Human() {
		return "Hello Human";
		
	}
	@RequestMapping("/name")
	public String Name(@RequestParam(value="name", required=true) String searchQuery) {
	        return "Hello " + searchQuery;
	    }
	@RequestMapping("/lastname")
	public String index(
	    @RequestParam(value = "name", required = true) String name,
	    @RequestParam(value = "lastname", required = true) String lastname) {
	    return "Hello " + name + " " + lastname;
	}
	
	@RequestMapping("/repeat")
	public String repeatGreeting(
	    @RequestParam(value = "name", required = true) String name,
	    @RequestParam(value = "times", required = true) int times) {
	    
	    StringBuilder result = new StringBuilder();
	    for (int i = 0; i < times; i++) {
	        result.append("Hello ").append(name);
	        result.append(" ");
	      
	    }
	    
	    return result.toString();
	}
}
