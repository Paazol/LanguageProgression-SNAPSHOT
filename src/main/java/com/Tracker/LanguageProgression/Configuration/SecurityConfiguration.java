package com.Tracker.LanguageProgression.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Tracker.LanguageProgression.Service.AdditionalUserDetails;

import lombok.AllArgsConstructor;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfiguration {

	private final AdditionalUserDetails additionalUserDetails;
	private final JwtAuthenticationFilter jwtAuthFilter;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .sessionManagement(sessionManagement -> sessionManagement.sessionFixation().migrateSession()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true))

        .authorizeHttpRequests((requests) -> requests
				.anyRequest().permitAll()
        )

        .formLogin(formLogin -> formLogin
        		.loginPage("/login")
        		.defaultSuccessUrl("/home")
        		.permitAll())
        		.userDetailsService(additionalUserDetails)
        		.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults())
        .cors(httpSecurityCorsConfigurer -> {
        	CorsConfiguration corsConfiguration = new CorsConfiguration();
        	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        	
        	corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
        	corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        	corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
        	corsConfiguration.setAllowCredentials(true);
        	
        	// as far as i know that thing is a replacement for "registry.addMapping("/**")" 
        	// located zin the corsConfigurer
        	source.registerCorsConfiguration("/**", corsConfiguration);
        	httpSecurityCorsConfigurer.configurationSource(source);
        });
		return http.build();
	}

    @Bean
    PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
    	return configuration.getAuthenticationManager();
    }

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(@NonNull CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:5173")
						.allowedMethods("GET", "POST", "PUT", "DELETE")
						.allowedHeaders("*")	
						.allowCredentials(true);
			}
		};
	}

}
