package com.java.test.app.controllers;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class home {
	
	@GetMapping("/")
	public String getHome(@RequestParam(defaultValue="World", required=false) String name, Model model) {
		model.addAttribute("name", name);
		return "index";
	}
}
