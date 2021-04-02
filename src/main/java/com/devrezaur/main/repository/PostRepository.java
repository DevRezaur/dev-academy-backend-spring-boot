package com.devrezaur.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.devrezaur.main.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
