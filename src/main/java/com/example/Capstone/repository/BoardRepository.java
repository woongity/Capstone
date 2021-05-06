package com.example.Capstone.repository;

import com.example.Capstone.domain.Board;
import com.example.Capstone.domain.Reply;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository {
    public boolean addBoard(Board board);
    public List<Board> getEveryBoard();
    public Board getBoardOne(int idx);
    public boolean addReply(Reply reply);
    public List<Reply> getReply(int boardIdx);
}
