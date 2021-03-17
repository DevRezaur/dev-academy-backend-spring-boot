package com.devrezaur.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/dashboard")
	public String dashboard() {
		return "Hello... User....Welcome to Dashboard";
	}
}
