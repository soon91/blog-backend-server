package com.sparta.blogbackendserver.dto;

import com.sparta.blogbackendserver.entity.Blog;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BlogResponseDto {
    private Long id;
    private String username;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String title;

    public BlogResponseDto(Blog blog) {
        this.id = blog.getId();
        this.username = blog.getUsername();
        this.contents = blog.getContents();
        this.createdAt = blog.getCreatedAt();
        this.modifiedAt = blog.getModifiedAt();
        this.title = blog.getTitle();
    }
}