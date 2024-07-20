package com.Tracker.LanguageProgression.DTO;

import jakarta.validation.constraints.NotEmpty;

public class UserDTO {
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String levelOfEnglish;
	
	@NotEmpty
	private Integer followers;
}
