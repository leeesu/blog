package com.sparta.blog.controller;

import com.sparta.blog.dto.BlogRequestDto;
import com.sparta.blog.entity.Blog;
import com.sparta.blog.repository.BlogRepository;
import com.sparta.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BlogController {

    private final BlogService blogService;


    // 글 등록
    @PostMapping("/api/blogs")
    public Blog createblog(@RequestBody BlogRequestDto requestDto) {
        Blog blog = blogService.create(requestDto);
        return blog;
    }
    // 등록된 전체 글 목록 조회
    @GetMapping("/api/blogs")
    public List<Blog> getBlogs() {

        return blogService.list();
    }
    //상세 글 조회
    @GetMapping("/api/blogs/{id}")
    public Optional<Blog> detailBlog(@PathVariable Long id)  {
        return blogService.detail(id);
    }


    //등록된 글 수정
    @PutMapping("/api/blogs/{id}")
    public Long updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
        blogService.update(id, requestDto);
        return id;
    }



    // 등록된 글 삭제
    @DeleteMapping("/api/blogs/{id}")
    public Long deleteBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
        blogService.delete(id, requestDto);
        return id;
    }






}

