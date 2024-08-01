package com.Tracker.LanguageProgression.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.Tracker.LanguageProgression.Entity.Posts;
import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Repository.PostsRepository;
import com.Tracker.LanguageProgression.Repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostsService {

	private final PostsRepository postsRepository;
	private final UserRepository userRepository;

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

	public List<Map<String, Object>> getAllPostsWithAuthorAvatar() {
		List<Posts> posts = postsRepository.findAll();
		List<Map<String, Object>> avatarsByID = new ArrayList<>();

		for (Posts post : posts) {
			Long authorId = post.getIdOfAnAuthor();
			User author = userRepository.findById(authorId).orElse(null);
			if (author != null) {
				Map<String, Object> avatarByID = new HashMap<>();
				avatarByID.put("post", post);
				avatarByID.put("avatarPicture", author.getProfilePicture());
				avatarByID.put("username", author.getUsername());
				avatarsByID.add(avatarByID);
			}
		}

		return avatarsByID;
	}
}
