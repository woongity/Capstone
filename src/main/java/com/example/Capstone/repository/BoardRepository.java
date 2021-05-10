package com.example.Capstone.repository;

import com.example.Capstone.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository {
    public boolean addBoard(Board board);
    public List<Board> getEveryBoard();
    public Optional<Board> getBoardOne(int idx);
}
