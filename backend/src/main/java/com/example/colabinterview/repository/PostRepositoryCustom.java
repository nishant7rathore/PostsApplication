package com.example.colabinterview.repository;

import com.example.colabinterview.dto.CommentDTO;
import com.example.colabinterview.dto.PostsWCommentsCountDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepositoryCustom {

    public List<PostsWCommentsCountDTO> findPostsWithCommentCounts();

    public List<CommentDTO> findCommentsForPost(int postId, int page, int pageSize);
}
