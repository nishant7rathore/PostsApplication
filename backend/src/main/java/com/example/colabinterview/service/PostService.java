package com.example.colabinterview.service;

import com.example.colabinterview.dto.CommentDTO;
import com.example.colabinterview.dto.PostsWCommentsCountDTO;
import com.example.colabinterview.repository.PostRepository;
import com.example.colabinterview.repository.PostRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    @Qualifier("postRepositoryCustomImpl")
    private PostRepositoryCustom postRepositoryCustom;


    public List<PostsWCommentsCountDTO> findPostsWithCommentCounts(){
        return postRepositoryCustom.findPostsWithCommentCounts();
    }

    public List<CommentDTO> findCommentsForPost(int postId, int page, int pageSize){
        List<CommentDTO> comments = postRepositoryCustom.findCommentsForPost(postId,page,pageSize);
        return comments;
    }


}
