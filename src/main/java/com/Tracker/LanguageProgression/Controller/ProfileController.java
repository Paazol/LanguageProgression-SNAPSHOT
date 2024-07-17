package com.Tracker.LanguageProgression.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Repository.UserRepository;

@Controller
public class ProfileController {

	// TODO when user is clicking certain link i want him to be redirected 
	// to the profile page which is gonna have his ID.
	// f.e. - /profile/69
	// instead of a normal - /profile
	UserRepository userRepository;
	
	@GetMapping("/profile/{id}")
    public String profile(User req, Model model, User request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getDetails());
		
		System.out.println("32");
        model.addAttribute("userId");
        return "profile";
    }
}
