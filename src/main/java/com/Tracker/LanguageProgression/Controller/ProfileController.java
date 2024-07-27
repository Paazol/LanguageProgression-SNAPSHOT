package com.Tracker.LanguageProgression.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Repository.UserRepository;
import com.Tracker.LanguageProgression.Service.AdditionalUserDetails;
import com.Tracker.LanguageProgression.Service.AuthenticationService;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ProfileController {
	
	// TODO halfway to my goal
	// i want to specify id of an image, f.e. - /profile/{userID}/upload/{imageID}
	// and then load it by url preliminarly protecting it by spring security
	// from other users
	
	UserRepository userRepository;
	
	@GetMapping("/profile/{id}")
	public String profile() {
        return "profile";
	}
	
	@PostMapping("/upload")
    public ResponseEntity<byte[]> createPost(@RequestParam("profilePicture") MultipartFile profilePicture, HttpSession session) throws IOException {
    	HttpHeaders headers = new HttpHeaders();
		Long userID = (Long) session.getAttribute("id");
		User user = userRepository.findById(userID).orElseThrow();
		
		byte[] image = user.getProfilePicture();
        Long id = (Long) session.getAttribute("id");
        headers.add("Location", "/profile/" + id);
        
        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).body(image);
    }
    
    
}
