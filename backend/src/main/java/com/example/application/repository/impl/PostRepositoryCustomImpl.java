package com.example.application.repository.impl;

import com.example.application.model.Comment;
import com.example.application.model.Post;
import com.example.application.model.QComment;
import com.example.application.model.QPost;
import com.example.application.repository.PostRepositoryCustom;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PostRepositoryCustomImpl implements PostRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Post> findPosts() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QPost post = QPost.post;
        return queryFactory.selectFrom(post).stream().toList();
    }

    public Map<Integer,Long> findCommentsCountByPost(){
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QComment comment = QComment.comment;
        List<Tuple> commentCounts = queryFactory.select(comment.post.id, comment.count())
                                                .from(comment)
                                                .groupBy(comment.post.id)
                                                .fetch();
        Map<Integer,Long> commentDict = new HashMap<>();
        commentCounts.forEach(tuple -> commentDict.put(tuple.get(0,Integer.class),tuple.get(1,Long.class)));
        return commentDict;
    }

    @Override
    public List<Comment> findCommentsForPost(int postId, int page, int pageSize) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QPost post = QPost.post;
        QComment comment = QComment.comment;
        return queryFactory.selectFrom(comment)
                           .where(comment.post.id.eq(postId))
                           .limit(pageSize)
                           .offset((long) (page - 1) *pageSize).fetch();
    }
}
