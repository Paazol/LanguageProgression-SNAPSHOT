package com.Tracker.LanguageProgression.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Tracker.LanguageProgression.Service.AdditionalUserDetails;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeContoller {
	
	AdditionalUserDetails userDetails;
	
	@GetMapping("/home")
	public String home(Model model) {
		
		// adding id to the frontend
		Long id = userDetails.getAuthenticatedUserID();
		model.addAttribute("id", id);
		return "home";
	}
}
