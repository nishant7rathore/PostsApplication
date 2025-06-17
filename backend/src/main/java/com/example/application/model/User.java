package com.example.application.model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(length = 80, unique = true, nullable = false)
    private String  userName;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
