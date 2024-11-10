package com.Tracker.LanguageProgression.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/security")
public class CsrfController {
	
	@Autowired
	private CsrfTokenRepository csrfTokenRepository;
	
	@GetMapping("/csrf-token")
    public String getCsrfToken(HttpServletRequest request, HttpServletResponse response) {
		CsrfToken csrfToken = csrfTokenRepository.generateToken(request);
		csrfTokenRepository.saveToken(csrfToken, request, response);
        return csrfToken.getToken();
    }
}