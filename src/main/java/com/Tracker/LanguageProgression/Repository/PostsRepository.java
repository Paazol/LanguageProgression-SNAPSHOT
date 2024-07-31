package com.Tracker.LanguageProgression.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Tracker.LanguageProgression.Entity.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

	List<Posts> findByIdOfAnAuthor(Long id);
}
