package com.Tracker.LanguageProgression.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Model.AuthenticationResponse;
import com.Tracker.LanguageProgression.Service.AuthenticationService;

@RestController
public class AuthController {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@ModelAttribute User request) {
        AuthenticationResponse response = authenticationService.register(request);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/profile"); // Redirect to a success page after registration
        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@ModelAttribute User request) {
        AuthenticationResponse response = authenticationService.authentication(request);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/home"); // Redirect to a dashboard page after login
        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).body(response);
    }
}
	