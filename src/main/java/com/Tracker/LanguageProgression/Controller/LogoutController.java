package com.Tracker.LanguageProgression.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.Tracker.LanguageProgression.Service.TokenBlacklistService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class LogoutController {
	
	TokenBlacklistService tokenBlacklistService;
	
	@PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String bearerToken) {
        String token = bearerToken.substring(7);
        tokenBlacklistService.addToBlacklist(token);
        return ResponseEntity.ok("Logged out successfully");
    }
}
