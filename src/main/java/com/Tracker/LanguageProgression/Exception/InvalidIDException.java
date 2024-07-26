package com.Tracker.LanguageProgression.Exception;

public class InvalidIDException extends RuntimeException {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 5130573711955167928L;

	public InvalidIDException(Long id) {
		super("There is no user with id " + id);
	}
}
