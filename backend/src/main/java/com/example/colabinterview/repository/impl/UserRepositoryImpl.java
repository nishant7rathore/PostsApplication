package com.example.colabinterview.repository.impl;

import com.example.colabinterview.model.QUser;
import com.example.colabinterview.model.User;
import com.example.colabinterview.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class UserRepositoryImpl {

//    @PersistenceContext
//    public EntityManager entityManager;
//
//    public List<User> findUserByUserName(String username) {
//
//        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
//        QUser user = QUser.user;
//        return queryFactory.selectFrom(user)
//                .where(user.userName.eq(username))
//                .fetch();
//    }
}
