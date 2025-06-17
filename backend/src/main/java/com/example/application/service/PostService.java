package com.example.application.service;

import com.example.application.dto.CommentDTO;
import com.example.application.dto.PostsWCommentsCountDTO;
import com.example.application.mapper.PostsMapper;
import com.example.application.model.Comment;
import com.example.application.model.Post;
import com.example.application.repository.PostRepository;
import com.example.application.repository.PostRepositoryCustom;
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
        Map<Integer, Long> comments = postRepositoryCustom.findCommentsCountByPost();
        return postsMapper.postsDTO(comments,posts);
    }

    public List<CommentDTO> findCommentsForPost(int postId, int page, int pageSize){
        List<Comment> comments = postRepositoryCustom.findCommentsForPost(postId,page,pageSize);
        return postsMapper.commentsDTO(comments);
    }
}
