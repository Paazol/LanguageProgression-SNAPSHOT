package com.Tracker.LanguageProgression.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="posts")
public class Post {

	@Id
	@GeneratedValue()
	private Long id;
	
	private String name;
	private String containment;
	private String suggestedLevelOfEnglish;
}
