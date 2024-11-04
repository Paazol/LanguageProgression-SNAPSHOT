package com.Tracker.LanguageProgression.Controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class CsrfController {

    @GetMapping("/csrf-token")
    public String getCsrfToken(CsrfToken csrfToken) {
        return csrfToken.getToken();
    }
}