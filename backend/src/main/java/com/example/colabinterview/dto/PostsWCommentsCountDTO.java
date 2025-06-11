package com.example.colabinterview.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;

public class PostsWCommentsCountDTO {
    private int id;
    private String title;
    private String content;
    private String author;
    private String createdAt;
    private int commentCount;
    public ArrayList<String> userPreview = new ArrayList<>();

    public PostsWCommentsCountDTO(int id, String title, String content, String author, String createdAt, int commentCount, ArrayList<String> userPreview) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.commentCount = commentCount;
        this.userPreview = userPreview == null ? new ArrayList<>() : userPreview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public ArrayList<String> getUserPreview() {
        return userPreview;
    }

    public void setUserPreview(ArrayList<String> userPreview) {
        this.userPreview = userPreview == null ? new ArrayList<>() : userPreview;
    }
}
