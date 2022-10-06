package com.sparta.spring_project.controller;

import com.sparta.spring_project.domain.Board;
import com.sparta.spring_project.domain.BoardRepository;
import com.sparta.spring_project.domain.BoardRequestDto;
import com.sparta.spring_project.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto){
        Board board = new Board (requestDto);
        return boardRepository.save ( board );
    }

    @GetMapping("/api/boards")
    public List<Board> getBoard(){return boardRepository.findAllByOrderByModifiedAtDesc ();}

    @GetMapping("api/boards/{id}")
    public Optional<Board> findById(@PathVariable Long id){
        return boardRepository.findById ( id );
    }

    @PutMapping("api/boards/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        boardService.update ( id, requestDto );
        return id;
    }


    @PostMapping("api/boards/{id}")
    public boolean checkPw(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        boolean result = boardService.checkPw(id, requestDto.getPassword ());
        return result;
    }

    @DeleteMapping("api/boards/{id}")
    public Long deleteBoard(@PathVariable Long id){
        boardRepository.deleteById ( id );
        return id;
    }
}
