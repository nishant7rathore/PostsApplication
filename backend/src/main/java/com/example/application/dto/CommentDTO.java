package com.example.application.dto;

import com.example.application.model.User;

import java.time.LocalDateTime;

public class CommentDTO {

    private int id;
    private String content;
    private String author;
    private String createdAt;
    private int postId;

    public CommentDTO(Integer id, String content, User author, LocalDateTime createdAt, Integer postId) {
        this.id = id;
        this.content = content;
        this.author = author.getUserName();
        this.createdAt = createdAt.toString();
        this.postId = postId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
