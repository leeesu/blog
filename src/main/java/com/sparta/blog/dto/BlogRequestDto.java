package com.sparta.blog.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BlogRequestDto {

    private String userName;

    private String password;

    private String title;

    private String content;

    //Timestamped class
    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
