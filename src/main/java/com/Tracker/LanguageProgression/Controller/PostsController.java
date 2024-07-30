package com.Tracker.LanguageProgression.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Tracker.LanguageProgression.Repository.PostsRepository;
import com.Tracker.LanguageProgression.Repository.UserRepository;
import com.Tracker.LanguageProgression.Service.PostsService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PostsController {
	
	PostsService postsService;
	UserRepository userRepository;
	PostsRepository postsRepository;
	
	@GetMapping("/profile/{id}/posts")
	public String userPosts(@PathVariable Long id, Model model) {

		model.addAttribute("posts", postsService.getAllAuthorPosts(id));
		return "posts";
	}
	
	
	@GetMapping("/profile/{id}/posts/create")
	public String postsCreate() {
		return "createPosts";
	}

}
