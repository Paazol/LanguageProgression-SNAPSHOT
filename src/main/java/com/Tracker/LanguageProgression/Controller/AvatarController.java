package com.Tracker.LanguageProgression.Controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Repository.UserRepository;
import com.Tracker.LanguageProgression.Service.AuthenticationService;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AvatarController {

	private final UserRepository userRepository;
	private final AuthenticationService authenticationService;

	@GetMapping("/user/{userID}/image/userAvatar")
    public ResponseEntity<byte[]> getProfilePicture(@PathVariable Long userID, HttpSession session) {

        Optional<User> user = userRepository.findById(userID);
        if (user.isPresent() && user.get().getProfilePicture() != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(user.get().getProfilePicture());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/user/{userID}/upload")
    public ResponseEntity<User> createProfilePicture(@PathVariable Long userID, @RequestParam("profilePicture") MultipartFile profilePicture, HttpSession session) throws IOException {
    	HttpHeaders headers = new HttpHeaders();

		User image = authenticationService.saveProfilePicture(profilePicture, session);
        headers.add("Location", "/" + userID);

        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).body(image);
    }
}
