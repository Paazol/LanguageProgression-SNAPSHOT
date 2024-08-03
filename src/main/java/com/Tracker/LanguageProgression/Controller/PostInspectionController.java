package com.Tracker.LanguageProgression.Controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Tracker.LanguageProgression.Entity.Posts;
import com.Tracker.LanguageProgression.Repository.PostsRepository;

@Controller
public class PostInspectionController {
	
	PostsRepository postsRepository;

	@GetMapping("/home/inspect/{postID}")
	private ResponseEntity<Posts> inspectPost(@PathVariable Long id) {
		Optional<Posts> post = postsRepository.findById(id);
		return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

}
