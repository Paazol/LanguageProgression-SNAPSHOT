package com.Tracker.LanguageProgression.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Repository.UserRepository;
import com.Tracker.LanguageProgression.Service.AdditionalUserDetails;


@Controller
public class ProfileController {
	
	User user = new User();
	UserRepository userRepository;
	
	@Autowired
	AdditionalUserDetails userDetails;
	
	// TODO well im close enough, but there's much code
	// to clean after this one will be done, still im getting closer.
	// today i finally can get currently logged Principal
	// for now i can't get his id.
	@GetMapping(path = {"/profile/{id}"})
	public String getCurrentUserId(Model model) {
		
        return "profile";
	}
}
