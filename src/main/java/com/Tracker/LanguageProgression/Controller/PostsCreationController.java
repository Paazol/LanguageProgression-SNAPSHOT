package com.Tracker.LanguageProgression.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tracker.LanguageProgression.Entity.Posts;
import com.Tracker.LanguageProgression.Service.PostsService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/profile/{id}/posts")
public class PostsCreationController {

    @Autowired
    private PostsService postsService;

    @PostMapping("/create")
    public ResponseEntity<Posts> createPost(@ModelAttribute Posts posts, HttpSession session) {
    	posts.setId(null);

        HttpHeaders headers = new HttpHeaders();
        Long id = (Long) session.getAttribute("id");

        postsService.createPost(id, posts);
        headers.add("Location", "/profile/" + id + "/posts");

        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).body(posts);
    }
}
