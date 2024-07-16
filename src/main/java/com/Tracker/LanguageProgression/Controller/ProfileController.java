package com.Tracker.LanguageProgression.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Repository.UserRepository;
import com.Tracker.LanguageProgression.Service.UserDetailsIServiceImplementation;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ProfileController {

	// TODO when user is clicking certain link i want him to be redirected 
	// to the profile page which is gonna have his ID.
	// f.e. - /profile/69
	// instead of a normal - /profile
	
	UserDetailsIServiceImplementation userService;
	
	@GetMapping("/profile/{id}")
		public String profile(Model model) {
		
		Authentication authentication =
				SecurityContextHolder.getContext().getAuthentication();
		
        User userDetails = (User) authentication.getPrincipal();
        Long userID = userDetails.getId();
        model.addAttribute("userID", userID);
        
        System.out.println(userID);
        
	    return "profile";
	}
}
