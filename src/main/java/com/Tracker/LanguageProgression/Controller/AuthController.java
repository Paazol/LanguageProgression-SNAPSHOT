package com.Tracker.LanguageProgression.Controller;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class AuthController {

	private AuthenticationService authenticationService;

	@PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@ModelAttribute User request) {
        AuthenticationResponse response = authenticationService.register(request);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/home");
        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@ModelAttribute User request) {
        AuthenticationResponse response = authenticationService.login(request);
        return ResponseEntity.ok(response);
    }
}
