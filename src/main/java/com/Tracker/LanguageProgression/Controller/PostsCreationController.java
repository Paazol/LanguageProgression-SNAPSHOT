package com.Tracker.LanguageProgression.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostsCreationController {
	@GetMapping("/profile/{id}/posts/create")
	public String createPost() {
		
		return "createPosts";
	}	
}
