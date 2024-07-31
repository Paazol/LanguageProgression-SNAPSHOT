package com.Tracker.LanguageProgression.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AvatarController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/profile/{userID}/image/userAvatar")
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
}
