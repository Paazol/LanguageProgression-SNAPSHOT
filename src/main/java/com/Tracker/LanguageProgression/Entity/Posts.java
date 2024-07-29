package com.Tracker.LanguageProgression.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	private Long idOfAnAuthor;

	private String title;
	@Size(max = 15100)
	private String containment;
	private String suggestedLevelOfEnglish;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
