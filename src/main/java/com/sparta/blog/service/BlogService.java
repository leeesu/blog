package com.sparta.blog.service;

import com.sparta.blog.dto.BlogRequestDto;
import com.sparta.blog.entity.Blog;
import com.sparta.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    // 글 등록
    @Transactional
    public Blog create(@RequestBody BlogRequestDto requestDto) {
        Blog blog = new Blog(requestDto);
        blogRepository.save(blog);
        return blog;
    }

    @Transactional
    public List<Blog> list() {
        //createAt으로 sort
        //Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        return blogRepository.findAllByOrderByCreatedAtDesc();
    }

    @Transactional
    public Optional<Blog> detail(@PathVariable Long id) {
        return blogRepository.findById(id);
    }

    @Transactional
    public boolean update(Long id, BlogRequestDto requestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );
        //비밀번호 확인
        if (blog.getPassword().equals(requestDto.getPassword())) {
            blog.update(requestDto);
            System.out.println("비밀번호가 일치합니다.");
            return true;
        }
        System.out.println("비밀번호가 일치하지 않습니다.");
        return false;

    }

    @Transactional
    public boolean delete(Long id, BlogRequestDto requestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );
        //비밀번호 확인
        if (blog.getPassword().equals(requestDto.getPassword())) {
            blogRepository.deleteById(id);
            System.out.println("비밀번호가 일치합니다.");
            return true;
        }
        System.out.println("비밀번호가 일치하지 않습니다.");
        return false;

    }
}