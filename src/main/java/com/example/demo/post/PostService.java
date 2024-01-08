package com.example.demo.post;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class PostService {
    private PostRepository postRepository;
    PostService(){
        this.postRepository = new PostRepository();
    }
    List<Post> findAll(){
        return this.postRepository.findAll();
    }
}
