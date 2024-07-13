package com.Tracker.LanguageProgression.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.Data;

@Data
@Controller
public class RegisterController {
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
}