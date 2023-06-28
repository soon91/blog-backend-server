package com.sparta.blogbackendserver.dto;

import lombok.Getter;

@Getter
public class BlogRequestDto {
    private String username;
    private String contents;
    private String title;
    private String password;
}