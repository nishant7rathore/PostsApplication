package com.example.colabinterview.service;

import com.example.colabinterview.model.Post;
import com.example.colabinterview.repository.PostRepository;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Iterable<Post> findALl(){
        Iterable<Post> posts = postRepository.findAll();
        return posts;
    }

}
