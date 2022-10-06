package com.sparta.spring_project.service;

import com.sparta.spring_project.domain.Board;
import com.sparta.spring_project.domain.BoardRepository;
import com.sparta.spring_project.domain.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long update(Long id, BoardRequestDto requestDto){
        Board board = boardRepository.findById ( id ).orElseThrow (
                () -> new IllegalArgumentException ("아이디가 존재하지 않습니다.")
        );
        board.update ( requestDto );
        return board.getId ();
    }

    public boolean checkPw(Long id, String password){
        Board board = boardRepository.findById ( id ).orElseThrow (
                () -> new IllegalArgumentException ("아이디가 존재하지 않습니다.")
        );
        if(board.getPassword ().equals ( password )){
            return true;
        }else{
            return false;
        }
    }

}
