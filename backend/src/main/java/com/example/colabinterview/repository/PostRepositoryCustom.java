package com.example.colabinterview.repository;

import com.example.colabinterview.dto.PostsWCommentsCountDTO;
import com.example.colabinterview.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepositoryCustom {
    public List<PostsWCommentsCountDTO> findPostsWithCommentCounts();
}
