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
		
		// WELL, i don't really know where to define all those variables so they'll be there
		Long id = userDetails.getUserID();
		String levelOfEnglish = userDetails.getLevelOfEnglish();
		
		model.addAttribute("levelOfEnglish", levelOfEnglish);
		model.addAttribute("id", id);
		return "home";
	}
}
