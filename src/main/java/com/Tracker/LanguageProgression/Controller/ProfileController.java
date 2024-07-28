package com.Tracker.LanguageProgression.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ProfileController {
	
	// TODO halfway to my goal
	// i want to specify id of an image, f.e. - /profile/{userID}/upload/{imageID}
	// and then load it by url preliminarly protected it by spring security
	// from other users
	
	
	@GetMapping("/profile/{userID}")
	public String profile() {
        return "profile";
	}  
}
