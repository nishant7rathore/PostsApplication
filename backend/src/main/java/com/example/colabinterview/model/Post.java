package com.example.colabinterview.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class Post {

    @Id
    private Integer id;

    @Column(length = 100, nullable = false)
    private String title;

    @JoinColumn(name = "user_id", nullable = false)
    private Integer userId;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "post", fetch=FetchType.LAZY)
    private Collection<Comment> comments;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User author;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
