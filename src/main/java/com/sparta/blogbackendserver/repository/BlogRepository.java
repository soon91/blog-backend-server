package com.sparta.blogbackendserver.repository;

import com.sparta.blogbackendserver.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByOrderByModifiedAtDesc();

    List<Blog> findAllByContentsContainsOrderByModifiedAtDesc(String keyword);
}
