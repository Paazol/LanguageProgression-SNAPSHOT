package com.Tracker.LanguageProgression.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Tracker.LanguageProgression.Service.AdditionalUserDetails;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeContoller {
	
	AdditionalUserDetails userDetails;
	
	@GetMapping("/home")
	public String home(HttpSession session) {
		
		// WELL, i don't really know where to define all those variables so they'll be there
		Long id = userDetails.getUserID();
		String levelOfEnglish = userDetails.getLevelOfEnglish();
		
		session.setAttribute("levelOfEnglish", levelOfEnglish);
		session.setAttribute("id", id);
		
		return "home";
	}
}
