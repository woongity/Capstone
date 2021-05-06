package com.example.Capstone.service;

import com.example.Capstone.domain.Board;
import com.example.Capstone.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void writeReply(){
        // write reply in this function
    }
    public void clickLiked(){
        // click like in this function
    }
    public List<Board> getEveryBoard(){
        return boardRepository.getEveryBoard();
    }
    public boolean addBoard(Board board){
        return boardRepository.addBoard(board);
    }
}