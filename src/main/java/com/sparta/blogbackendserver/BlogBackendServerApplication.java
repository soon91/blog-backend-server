package com.sparta.blogbackendserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BlogBackendServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogBackendServerApplication.class, args);
    }

}
