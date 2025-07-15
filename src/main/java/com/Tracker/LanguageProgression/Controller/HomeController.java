package com.Tracker.LanguageProgression.Controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tracker.LanguageProgression.Entity.User;
import com.Tracker.LanguageProgression.Service.AdditionalUserDetails;
import com.Tracker.LanguageProgression.Service.PostsService;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class HomeController {

    private final AdditionalUserDetails userDetails;
    private final PostsService postsService;
    
    @GetMapping("/getHomeData")
    public Map<String, Object> home(Principal principal, HttpSession session) {
        Map<String, Object> response = new HashMap<>();

        if (principal != null && !(principal instanceof AnonymousAuthenticationToken)) {
            Long id = userDetails.getAuthenticatedUserID();
            User user = userDetails.loadUserById(id);
            String levelOfEnglish = userDetails.getLevelOfEnglish();

            List<Map<String, Object>> avatarByID = postsService.getAllPostsWithAuthorAvatar();
            response.put("avatarByID", avatarByID);
            response.put("user", user);

            session.setAttribute("levelOfEnglish", levelOfEnglish);
            session.setAttribute("id", id);
        }

        return response;
    }
}
