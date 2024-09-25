package com.kodbook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodbook.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

	void save(List<Post> posts);

}
