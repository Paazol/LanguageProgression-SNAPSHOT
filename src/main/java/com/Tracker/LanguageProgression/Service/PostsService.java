package com.Tracker.LanguageProgression.Service;

import org.springframework.stereotype.Service;

import com.Tracker.LanguageProgression.Entity.Posts;
import com.Tracker.LanguageProgression.Repository.PostsRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostsService {
	
	private PostsRepository postsRepository;
	
	public void savingPost(Posts posts) {
		
		posts.setName(posts.getName());
		posts.setContainment(posts.getContainment());
		posts.setSuggestedLevelOfEnglish(posts.getSuggestedLevelOfEnglish());
		
		postsRepository.save(posts);
	}
}
