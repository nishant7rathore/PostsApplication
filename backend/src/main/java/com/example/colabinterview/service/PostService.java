package com.example.colabinterview.service;

import com.example.colabinterview.dto.CommentDTO;
import com.example.colabinterview.dto.PostsWCommentsCountDTO;
import com.example.colabinterview.mapper.PostsMapper;
import com.example.colabinterview.model.Comment;
import com.example.colabinterview.model.Post;
import com.example.colabinterview.repository.PostRepository;
import com.example.colabinterview.repository.PostRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    @Qualifier("postRepositoryCustomImpl")
    private PostRepositoryCustom postRepositoryCustom;

    @Autowired
    private PostsMapper postsMapper;

    public List<PostsWCommentsCountDTO> findPostsWithCommentCounts(){
        List<Post> posts = postRepositoryCustom.findPosts();
        Map<Integer, Long> comments = postRepositoryCustom.findCommentsByPost();
        return postsMapper.postsDTO(comments,posts);
    }

    public List<CommentDTO> findCommentsForPost(int postId, int page, int pageSize){
        List<Comment> comments = postRepositoryCustom.findCommentsForPost(postId,page,pageSize);
        return postsMapper.commentsDTO(comments);
    }
}
