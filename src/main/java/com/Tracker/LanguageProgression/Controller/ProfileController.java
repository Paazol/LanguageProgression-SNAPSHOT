package com.Tracker.LanguageProgression.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Tracker.LanguageProgression.Service.AdditionalUserDetails;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProfileController {
	
	AdditionalUserDetails userDetails;
	
	@GetMapping(path = {"/profile/{id}"})
	public String profile(HttpSession session) {
		
		
        return "profile";
	}
}
