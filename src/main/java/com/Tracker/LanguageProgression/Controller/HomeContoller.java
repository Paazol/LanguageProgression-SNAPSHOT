package com.Tracker.LanguageProgression.Controller;

import java.security.Principal;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Repository.UserRepository;
import com.Tracker.LanguageProgression.Service.AdditionalUserDetails;
import com.Tracker.LanguageProgression.Service.PostsService;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeContoller {
	
	AdditionalUserDetails userDetails;
	PostsService postsService;
	UserRepository repository;
	
	@GetMapping("/home")
	public String home(Principal principal, HttpSession session, Model model) {
				
		
		// Checking to prevent the site from being down
		// cause of a null id's
		// Lol just noticed, for some reason if you're removing this checking 
		// the site is just getting demolished
		if (principal != null || principal instanceof AnonymousAuthenticationToken) {
		// WELL, i don't really know where to define all those variables so they'll be here
			Long id = userDetails.getAuthenticatedUserID();
			User user = userDetails.loadUserById(id);
			String levelOfEnglish = userDetails.getLevelOfEnglish();
			System.out.println(postsService.getAllPosts());
			
			model.addAttribute("posts", postsService.getAllPosts());
			model.addAttribute("user", user);
			
			session.setAttribute("levelOfEnglish", levelOfEnglish);
			session.setAttribute("id", id);
        }
		
		return "home";
	}
}
