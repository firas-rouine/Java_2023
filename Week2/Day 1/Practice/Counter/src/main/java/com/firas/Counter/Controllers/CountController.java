package com.firas.Counter.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;

@Controller
public class CountController {
	@GetMapping("/counter")
	public String count(HttpSession session) {
		if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        } else {
            int count = (int) session.getAttribute("count");
            session.setAttribute("count", count);
        }
		return "counter.jsp";
		
	}
	
	@GetMapping("/")
	public String index(HttpSession session) {
		 if (session.getAttribute("count") == null) {
	            session.setAttribute("count", 0);
	        } else {
	            int count = (int) session.getAttribute("count");
	            session.setAttribute("count", count + 1);
	        }
		return "index.jsp";
		
	}
	@GetMapping("/increment")
	public String increment(HttpSession session) {
		 if (session.getAttribute("count") == null) {
	            session.setAttribute("count", 0);
	        } else {
	            int count = (int) session.getAttribute("count");
	            session.setAttribute("count", count + 2);
	        }
		return "increment.jsp";
		
	}
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		
		return "redirect:/counter";
		
	}

}
