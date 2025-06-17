package com.example.application.repository;

import com.example.application.model.Comment;
import com.example.application.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PostRepositoryCustom {

    public List<Post> findPosts();
    public Map<Integer,Long> findCommentsCountByPost();
    public List<Comment> findCommentsForPost(int postId, int page, int pageSize);
}
