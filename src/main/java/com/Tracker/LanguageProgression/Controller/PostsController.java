package com.Tracker.LanguageProgression.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Tracker.LanguageProgression.Entity.Posts;
import com.Tracker.LanguageProgression.Service.PostsService;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PostsController {

	private final PostsService postsService;
	
	@GetMapping("/{id}/posts")
	public String userPosts(@PathVariable Long id, Model model) {
		model.addAttribute("posts", postsService.getAllAuthorPosts(id));
		return "posts";
	}
	
	@GetMapping("/{id}/posts/{postID}")
    public String viewPost(@PathVariable Long postID, Model model) {
        // Fetch the post by ID and add it to the model
        Posts post = postsService.getPostById(postID);
        model.addAttribute("post", post);
        return "inspectPost"; // Return the name of the Thymeleaf template for viewing a single post
    }

	@GetMapping("/{id}/create")
	public String postsCreate() {
		return "createPosts";
	}
	
	
	@PostMapping("/{id}/createPost/upload")
    public ResponseEntity<Posts> createPost(@ModelAttribute Posts posts, HttpSession session) {
    	posts.setId(null);

        HttpHeaders headers = new HttpHeaders();
        Long id = (Long) session.getAttribute("id");

        postsService.createPost(id, posts);
        headers.add("Location", "/profile/" + id + "/posts");

        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).body(posts);
    }
}
