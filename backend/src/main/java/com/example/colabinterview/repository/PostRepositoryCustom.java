package com.example.colabinterview.repository;

import com.example.colabinterview.model.Comment;
import com.example.colabinterview.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PostRepositoryCustom {

    public List<Post> findPosts();
    public Map<Integer,Long> findCommentsCountByPost();
    public List<Comment> findCommentsForPost(int postId, int page, int pageSize);
}
