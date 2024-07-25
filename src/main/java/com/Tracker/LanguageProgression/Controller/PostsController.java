package com.Tracker.LanguageProgression.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostsController {
	
	
	@GetMapping("/profile/{id}/posts")
	public String userPosts() {
		return "posts";
	}
	
	
	@GetMapping("/profile/{id}/posts/create")
	public String postsCreate() {
		return "createPosts";
	}

}
