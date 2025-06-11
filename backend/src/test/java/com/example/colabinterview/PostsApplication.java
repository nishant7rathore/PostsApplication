package com.example.colabinterview;

import org.springframework.boot.SpringApplication;

public class PostsApplication {

    public static void main(String[] args) {
        SpringApplication.from(PostsApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
