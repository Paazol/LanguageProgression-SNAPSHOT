package com.Tracker.LanguageProgression.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.Tracker.LanguageProgression.Entity.Posts;
import com.Tracker.LanguageProgression.Repository.PostsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostsService {
	
	private PostsRepository postsRepository;
	
	public void createPost(@PathVariable("userID") Long userID, Posts posts) {
		posts.setId(null);
		
		posts.setTitle(posts.getTitle());
		posts.setContainment(posts.getContainment());
		posts.setSuggestedLevelOfEnglish(posts.getSuggestedLevelOfEnglish());
		posts.setIdOfAnAuthor(userID);
		postsRepository.save(posts);
	}
	
	public List<Posts> getAllPosts() {
		return postsRepository.findAll();
	}
	
	public List<Posts> getAllAuthorPosts(Long id) {
		
		return postsRepository.findByIdOfAnAuthor(id);
	}
}
