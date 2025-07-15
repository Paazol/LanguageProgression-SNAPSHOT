package com.Tracker.LanguageProgression.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Model.AuthenticationResponse;
import com.Tracker.LanguageProgression.Service.AuthenticationService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class RegisterController {

	private AuthenticationService authenticationService;

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody User request) {
		AuthenticationResponse response = authenticationService.register(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}