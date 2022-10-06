package com.sparta.spring_project.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Board extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String password;

    public Board(String username, String content, String password){
        this.username = username;
        this.content = content;
        this.password = password;
    }

    public Board(BoardRequestDto requestDto){
        this.username = requestDto.getUsername ();
        this.content = requestDto.getContent ();
        this.password = requestDto.getPassword ();
    }

    public void update(BoardRequestDto requestDto){
        this.username = requestDto.getUsername ();
        this.content = requestDto.getContent ();
        this.password = requestDto.getPassword ();
    }
}
