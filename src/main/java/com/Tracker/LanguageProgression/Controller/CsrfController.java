package com.Tracker.LanguageProgression.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/security")
public class CsrfController {

    @GetMapping("/csrf-token")
    public JSONResponse getCsrfToken(HttpServletRequest request) {
        JSONResponse jsonResponse = new JSONResponse();
        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        String token = csrfToken.getToken();
        jsonResponse.addMsg("csrfToken", token);
        return jsonResponse;
    }
}