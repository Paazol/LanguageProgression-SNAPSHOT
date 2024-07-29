package com.Tracker.LanguageProgression.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ProfileController {
	
	@GetMapping("/profile/{userID}")
	public String profile() {
        return "profile";
	}  
}
