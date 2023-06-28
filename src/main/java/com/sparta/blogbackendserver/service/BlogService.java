package com.sparta.blogbackendserver.service;

import com.sparta.blogbackendserver.dto.BlogRequestDto;
import com.sparta.blogbackendserver.dto.BlogResponseDto;
import com.sparta.blogbackendserver.entity.Blog;
import com.sparta.blogbackendserver.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public BlogResponseDto createBlog(BlogRequestDto requestDto) { // 게시글 작성
        // RequestDto -> Entity
        Blog blog = new Blog(requestDto);

        // DB 저장
        Blog saveBlog = blogRepository.save(blog);

        // Entity -> ResponseDto
        BlogResponseDto blogResponseDto = new BlogResponseDto(blog);

        return blogResponseDto;
    }

    public List<BlogResponseDto> getBlogs() { // 전체 게시글 조회
        // DB 조회
        return blogRepository.findAllByOrderByModifiedAtDesc().stream().map(BlogResponseDto::new).toList();
    }

    public BlogResponseDto getSelectBlog(Long id) { // 선택 게시글 조회
        // 해당 게시글이 DB에 존재하는지 확인
        Blog blog = findBlog(id);

        return new BlogResponseDto(blog);
    }

    @Transactional
    public BlogResponseDto updateBlog(Long id, BlogRequestDto requestDto) { // 선택 게시글 수정
        // 해당 게시글이 DB에 존재하는지 확인
        Blog blog = findBlog(id);
        if (requestDto.getPassword().equals(blog.getPassword())) {
            // 게시글 내용 수정
            blog.update(requestDto);

            return new BlogResponseDto(blog);
        } else return new BlogResponseDto(blog);
    }

    public String deleteBlog(Long id, BlogRequestDto requestDto) { // 선택 게시글 삭제
        // 해당 게시글이 DB에 존재하는지 확인
        Blog blog = findBlog(id);
        String response = new String();
        if (requestDto.getPassword().equals(blog.getPassword())) {
            // 게시글 삭제
            blogRepository.delete(blog);
            response = "삭제 성공";

            return response;
        } else {
            response = "삭제 실패";

            return response;
        }

    }

    private Blog findBlog(Long id) {
        return blogRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글은 존재하지 않습니다.")
        );
    }
}
