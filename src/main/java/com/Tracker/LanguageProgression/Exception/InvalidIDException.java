package com.Tracker.LanguageProgression.Exception;

public class InvalidIDException extends RuntimeException {
		
	public InvalidIDException(Long id) {
		super("There is no user with id " + id);
	}
}
