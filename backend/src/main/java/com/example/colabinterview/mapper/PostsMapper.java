package com.example.colabinterview.mapper;
import com.example.colabinterview.dto.CommentDTO;
import com.example.colabinterview.dto.PostsWCommentsCountDTO;
import com.example.colabinterview.model.Comment;
import com.example.colabinterview.model.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PostsMapper {

    public List<PostsWCommentsCountDTO> postsDTO(Map<Integer, Long> commentDict, List<Post> posts) {
        return posts.stream().map(post -> new PostsWCommentsCountDTO(post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getAuthor().getUserName(),
                post.getCreatedAt().toString(),
                commentDict.getOrDefault(post.getId(),0L).intValue(),
                new ArrayList<String>())).collect(Collectors.toList());
    }

    public List<CommentDTO> commentsDTO(List<Comment> comments) {
        return comments.stream().map(comment -> new CommentDTO(comment.getId(),
                comment.getContent(),
                comment.getAuthor(),
                comment.getCreatedAt(),
                comment.getPost().getId())).toList();
    }
}
