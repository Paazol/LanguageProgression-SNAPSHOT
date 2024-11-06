package com.Tracker.LanguageProgression.Service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TokenBlacklistService {

	private StringRedisTemplate redisTemplate;

	public void addToBlacklist(String token) {
	    redisTemplate.opsForValue().set(token, "blacklisted");
	}

    public boolean isBlacklisted(String token) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(token));
    }
}
