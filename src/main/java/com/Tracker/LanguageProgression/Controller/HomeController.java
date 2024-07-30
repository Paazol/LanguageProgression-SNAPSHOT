package com.Tracker.LanguageProgression.Controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

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
public class HomeController {
	
	AdditionalUserDetails userDetails;
	PostsService postsService;
	UserRepository repository;
	
	@GetMapping("/home")
	public String home(Principal principal, HttpSession session, Model model) {
		if (principal != null || principal instanceof AnonymousAuthenticationToken) {
			Long id = userDetails.getAuthenticatedUserID();
			User user = userDetails.loadUserById(id);
			String levelOfEnglish = userDetails.getLevelOfEnglish();
			
			List<Map<String, Object>> postsWithAvatar = postsService.getAllPostsWithAuthorAvatar();
			model.addAttribute("postsWithAvatar", postsWithAvatar);
			model.addAttribute("user", user);
			
			session.setAttribute("levelOfEnglish", levelOfEnglish);
			session.setAttribute("id", id);
		}
		
		return "home";
	}
}
