package com.sparta.blog.repository;

import com.sparta.blog.entity.Blog;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    //  List<Blog> findAllByOrderByModifiedAtDesc();
    //마지막 수정 날짜기준으로 내림차순
    List<Blog> findAllByOrderByCreatedAtDesc();
    //작성일 기준으로 내림차순
}
