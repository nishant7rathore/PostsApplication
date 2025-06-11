package com.example.colabinterview.repository.impl;

import com.example.colabinterview.model.Post;
import com.example.colabinterview.repository.PostRepository;
import com.example.colabinterview.repository.PostRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostRepositoryCustomImpl implements PostRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public String findPostsWithCoommentCounts() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QPost post = QPost.post;
        return queryFactory.selectFrom(post).
    }
}
