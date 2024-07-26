package com.Tracker.LanguageProgression.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "posts")
public class Posts {

	@Id
	@GeneratedValue()
	private Long id;

	private String title;
	@Size(max = 15100)
	private String containment;
	private String suggestedLevelOfEnglish;
}
