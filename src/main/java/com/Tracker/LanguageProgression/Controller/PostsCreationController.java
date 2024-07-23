package com.Tracker.LanguageProgression.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tracker.LanguageProgression.Entity.Posts;
import com.Tracker.LanguageProgression.Service.PostsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/profile/{id}/posts")
public class PostsCreationController {

    @Autowired
    private PostsService postsService;

    @PostMapping("/create")
    public ResponseEntity<String> createPost(@RequestBody Posts posts) {
        postsService.createPost(posts);
        return ResponseEntity.ok("Post created successfully!");
    }
}
