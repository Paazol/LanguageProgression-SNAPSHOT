package com.Tracker.LanguageProgression.Controller;

import java.util.Base64;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Repository.UserRepository;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("")
public class ProfileController {
	private final UserRepository userRepository;

	@GetMapping("/user/{userID}")
	public String profile(@PathVariable Long userID, Model model) {

		Optional<User> idOfAUser = userRepository.findById(userID);

		model.addAttribute("userID", userID);

		if (idOfAUser.isPresent() && idOfAUser.get().getProfilePicture() != null) {
			byte[] profilePictureBytes = idOfAUser.get().getProfilePicture();
			String base64Image = Base64.getEncoder().encodeToString(profilePictureBytes);
			model.addAttribute("avatarByID", "data:image/jpeg;base64," + base64Image);
		} else {
			String avatarPath = "/images/userDefaultIcon.png";
			model.addAttribute("avatarByID", avatarPath);
		}
		return "profile";
	}
}
