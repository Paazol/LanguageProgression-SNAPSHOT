package com.Tracker.LanguageProgression.Controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Repository.UserRepository;
import com.Tracker.LanguageProgression.Service.UserDetailsServiceImplementation;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {
	
	User user = new User();
	UserRepository userRepository;
	
	// TODO well im close enough, but there's much code
	// to clean after this one will be done, but im getting closer.
	// today i finally can get currently logged Principal
	// but for now i can't get his id.
	@GetMapping(path = {"/profile/{id}"})
	public String getCurrentUserId(User request, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long principal = request.getId();
        User user = user.find;
        System.out.println(principal);
        model.addAttribute("userId", authentication);
        return "profile";
	}
}
