package com.example.colabinterview.repository.impl;

import com.example.colabinterview.dto.CommentDTO;
import com.example.colabinterview.dto.PostsWCommentsCountDTO;
import com.example.colabinterview.model.Comment;
import com.example.colabinterview.model.Post;
import com.example.colabinterview.model.QComment;
import com.example.colabinterview.model.QPost;
import com.example.colabinterview.repository.PostRepositoryCustom;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class PostRepositoryCustomImpl implements PostRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PostsWCommentsCountDTO> findPostsWithCommentCounts() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QPost post = QPost.post;
        QComment comment = QComment.comment;
        List<Post> posts = queryFactory.selectFrom(post).stream().toList();
        List<Tuple> commentCounts = queryFactory.select(comment.post.id, comment.count())
                                                .from(comment)
                                                .groupBy(comment.post.id)
                                                .fetch();
        Map<Integer,Long> commentDict = new HashMap<>();
        commentCounts.forEach(tuple -> commentDict.put(tuple.get(0,Integer.class),tuple.get(1,Long.class)));
        List<PostsWCommentsCountDTO> postsDTO = jsonPostsWithCommentsCount(commentDict,posts);
        return postsDTO;
    }

    private List<PostsWCommentsCountDTO> jsonPostsWithCommentsCount(Map<Integer, Long> commentDict, List<Post> posts) {
        List<PostsWCommentsCountDTO> postsDTO = posts.stream().map(post -> new PostsWCommentsCountDTO(post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getAuthor().getUserName(),
                post.getCreatedAt().toString(),
                commentDict.getOrDefault(post.getId(),0L).intValue(),
                new ArrayList<String>())).collect(Collectors.toList());
        return postsDTO;
    }

    @Override
    public List<CommentDTO> findCommentsForPost(int postId, int page, int pageSize) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QPost post = QPost.post;
        QComment comment = QComment.comment;
        List<Comment> comments = queryFactory.selectFrom(comment)
                .where(comment.post.id.eq(postId))
                .limit(pageSize)
                .offset((long) (page - 1) *pageSize).fetch();
        return jsonComments(comments);
}

    private List<CommentDTO> jsonComments(List<Comment> comments) {
        return comments.stream().map(comment -> new CommentDTO(comment.getId(),
                comment.getContent(),
                comment.getAuthor(),
                comment.getCreatedAt(),
                comment.getPost().getId())).toList();
    }

}
