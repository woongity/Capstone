package com.example.Capstone.service;

import com.example.Capstone.domain.Board;
import com.example.Capstone.repository.BoardRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
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
    public Optional<Board> getBoardOne(int idx){
        return boardRepository.getBoardOne(idx);
    }
}