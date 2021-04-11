package com.devrezaur.main.service;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devrezaur.main.model.Post;
import com.devrezaur.main.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepo;
	
	public List<Post> getPosts(int courseId) {
		List<Post> posts = postRepo.findByCourseId(courseId);
		if(posts != null)
			Collections.reverse(posts);
		return posts;
	}
	
	public Post createPost(Post post) {
		return postRepo.save(post);
	}
}
