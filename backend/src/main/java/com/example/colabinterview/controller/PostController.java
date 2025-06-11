package com.example.colabinterview.controller;

import com.example.colabinterview.dto.CommentDTO;
import com.example.colabinterview.dto.PostsWCommentsCountDTO;
import com.example.colabinterview.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public String findAll() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<PostsWCommentsCountDTO> posts = postService.findPostsWithCommentCounts();
        return mapper.writeValueAsString(posts);
    }

    @GetMapping("/posts/{postId}/comments")
    public String findCommentsForPost(@PathVariable int postId, @RequestParam Map<String, String> params) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        int page = Integer.parseInt(params.getOrDefault("page","1"));
        int pageSize = Integer.parseInt(params.getOrDefault("per-page","1"));
        List<CommentDTO> posts = postService.findCommentsForPost(postId, page, pageSize).stream().toList();
        return mapper.writeValueAsString(posts);
    }

}
