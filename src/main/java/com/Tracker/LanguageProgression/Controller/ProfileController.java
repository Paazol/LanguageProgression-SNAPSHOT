package com.Tracker.LanguageProgression.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
	
	@GetMapping(path = {"/profile/{id}"})
	public String profile() {
		
        return "profile";
	}
}
