package com.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.emp.entities.Employee;



@Controller
public class HomeController {
	
	@GetMapping(value={"/home","/"})
	public String home( Model model)
	{
		model.addAttribute("title", "Home");
		return "home";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
	
		model.addAttribute("title", "Register");
		model.addAttribute("user", new Employee() );
		return "signup";
	}
	
}
