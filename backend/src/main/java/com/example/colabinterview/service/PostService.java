package com.example.colabinterview.service;

import com.example.colabinterview.dto.PostsWCommentsCountDTO;
import com.example.colabinterview.model.Post;
import com.example.colabinterview.repository.PostRepository;
import com.example.colabinterview.repository.PostRepositoryCustom;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    @Qualifier("postRepositoryCustomImpl")
    private PostRepositoryCustom postRepositoryCustom;


    public Iterable<PostsWCommentsCountDTO> findPostsWithCommentCounts(){
        Iterable<PostsWCommentsCountDTO> posts = postRepositoryCustom.findPostsWithCommentCounts();
        return posts;
    }

}
