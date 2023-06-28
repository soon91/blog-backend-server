package com.sparta.blogbackendserver.controller;

import com.sparta.blogbackendserver.dto.BlogRequestDto;
import com.sparta.blogbackendserver.dto.BlogResponseDto;
import com.sparta.blogbackendserver.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/posts") // 게시글 작성
    public BlogResponseDto createBlog(@RequestBody BlogRequestDto requestDto) {
        return blogService.createBlog(requestDto);
    }

    @GetMapping("/posts") // 전체 게시글 조회
    public List<BlogResponseDto> getBlogs() {
        return blogService.getBlogs();
    }

    @GetMapping("/posts/{id}") // 선택 게시글 조회
    public BlogResponseDto getSelectBlog(@PathVariable Long id) {
        return blogService.getSelectBlog(id);
    }

    @PutMapping("/posts/{id}") // 선택 게시글 수정
    public BlogResponseDto updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
        return blogService.updateBlog(id, requestDto);
    }

    @DeleteMapping("/posts/{id}") // 선택 게시글 삭제
    public String deleteBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
        return blogService.deleteBlog(id, requestDto);
    }
}