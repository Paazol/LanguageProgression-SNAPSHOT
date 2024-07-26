package com.Tracker.LanguageProgression.Service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Exception.InvalidIDException;
import com.Tracker.LanguageProgression.Repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdditionalUserDetails implements UserDetailsService {

	private final UserRepository userRepository;
	
	private User getAuthenticatedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return (User) authentication.getPrincipal();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}
	
	public User loadUserById(Long id) {
		
		return userRepository.findById(id).orElseThrow(() -> new InvalidIDException(id));
	}

	public Long getAuthenticatedUserID() {

		Long id = getAuthenticatedUser().getId();
		return id;

	}
	
	public String getLevelOfEnglish() {
		
		String levelOfEnglish = getAuthenticatedUser().getLevelOfEnglish();
		return levelOfEnglish;
	}
	
}
