package com.Tracker.LanguageProgression.Service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Tracker.LanguageProgression.Entity.Role;
import com.Tracker.LanguageProgression.Entity.Token;
import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Model.AuthenticationResponse;
import com.Tracker.LanguageProgression.Repository.TokenRepository;
import com.Tracker.LanguageProgression.Repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticationService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	private final TokenRepository tokenRepository;

	public AuthenticationResponse register(User request) {

		// check if user already exist. if exist then authenticate him
		if (userRepository.findByUsername(request.getUsername()).isPresent()) {
			return new AuthenticationResponse(null, null, "User already exist");
		}

		User user = new User();
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setLevelOfEnglish(request.getLevelOfEnglish());
		user.setFollowers(request.getFollowers());
		user.setRole(Role.USER);
		user = userRepository.save(user);

		String accessToken = jwtService.generateAccessToken(user);
		String refreshToken = jwtService.generateRefreshToken(user);

		saveUserToken(accessToken, refreshToken, user);
		return new AuthenticationResponse(accessToken, refreshToken, "User registration was successful");

	}

	public User saveProfilePicture(@RequestParam("profilePicture") MultipartFile profilePicture, HttpSession session) throws IOException {

		// resizing
        int targetWidth = 230;
        int targetHeight = 230;

        //from multipartfile to the bufferedimage
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(profilePicture.getBytes()));
        //resizing an image
        BufferedImage resizedImage = Scalr.resize(originalImage, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_EXACT, targetWidth, targetHeight);

        // converting BufferedImage back to byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(resizedImage, "jpg", baos);
        byte[] resizedImageBytes = baos.toByteArray();

        // save everything
        Long userID = (Long) session.getAttribute("id");
        User user = userRepository.findById(userID).orElseThrow(() -> new RuntimeException("User not found"));
        user.setProfilePicture(resizedImageBytes);
        baos.close();
        return userRepository.save(user);
    }

	public AuthenticationResponse login(User request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		User user = userRepository.findByUsername(request.getUsername()).orElseThrow();
		String accessToken = jwtService.generateAccessToken(user);
		String refreshToken = jwtService.generateRefreshToken(user);

		revokeAllTokenByUser(user);
		saveUserToken(accessToken, refreshToken, user);

		return new AuthenticationResponse(accessToken, refreshToken, "User login was successful");

	}

	private void revokeAllTokenByUser(User user) {
		List<Token> validTokens = tokenRepository.findAllAccessTokensByUser(user.getId());
		if (validTokens.isEmpty()) {
			return;
		}

		validTokens.forEach(token -> {
			token.setLoggedOut(true);
		});

		tokenRepository.saveAll(validTokens);
	}

	private void saveUserToken(String accessToken, String refreshToken, User user) {
		Token token = new Token();
		token.setAccessToken(accessToken);
		token.setRefreshToken(refreshToken);
		token.setLoggedOut(false);
		token.setUser(user);
		tokenRepository.save(token);
	}

	public ResponseEntity<AuthenticationResponse> refreshToken(HttpServletRequest request,
			HttpServletResponse response) {
		// extract token from the authorization header
		String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

		String token = authHeader.substring(7);

		// extract username from the token
		String username = jwtService.extractUsername(token);

		// check if user exist in the database
		User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("No user found"));

		// check if token is valid
		if (jwtService.isValidRefreshToken(token, user)) {
			// generate access token
			String accessToken = jwtService.generateAccessToken(user);
			String refreshToken = jwtService.generateRefreshToken(user);

			revokeAllTokenByUser(user);
			saveUserToken(accessToken, refreshToken, user);

			return new ResponseEntity<>(
					new AuthenticationResponse(accessToken, refreshToken, "New token generated"), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

	}
}