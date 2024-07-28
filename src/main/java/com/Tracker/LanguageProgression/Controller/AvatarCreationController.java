package com.Tracker.LanguageProgression.Controller;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Repository.UserRepository;
import com.Tracker.LanguageProgression.Service.AuthenticationService;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AvatarCreationController {

	UserRepository userRepository;
	AuthenticationService authenticationService;
	
    @PostMapping("/profile/{userID}/upload")
    public ResponseEntity<User> createPost(@PathVariable Long userID,@RequestParam("profilePicture") MultipartFile profilePicture, HttpSession session) throws IOException {
    	HttpHeaders headers = new HttpHeaders();
		
		User image = authenticationService.saveProfilePicture(profilePicture, session);
        headers.add("Location", "/profile/" + userID);
        
        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).body(image);
    }
}
