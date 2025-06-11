package com.example.colabinterview.controller;

import com.example.colabinterview.dto.PostsWCommentsCountDTO;
import com.example.colabinterview.model.Post;
import com.example.colabinterview.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public String findAll() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<PostsWCommentsCountDTO> posts = StreamSupport.stream(postService.findPostsWithCommentCounts().spliterator(), false).toList();
        return mapper.writeValueAsString(posts);
    }

}
