package com.example.application;

import org.springframework.boot.SpringApplication;

public class PostsApplication {

    public static void main(String[] args) {
        SpringApplication.from(com.example.application.PostsApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
