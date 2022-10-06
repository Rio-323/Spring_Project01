package com.sparta.spring_project.domain;

import lombok.Getter;

@Getter
public class BoardRequestDto {
    private String username;
    private String content;
    private String password;
}
