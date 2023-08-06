package com.firas.DisplayDate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	@RequestMapping("/date")
	public String date (Model model) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMM dd, yyyy");
		String date =dateFormat.format(new Date());
		model.addAttribute("date", date);
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String time (Model model) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a"	);
		String time =timeFormat.format(new Date());
		model.addAttribute("time", time);
		return "time.jsp";
	}

}
