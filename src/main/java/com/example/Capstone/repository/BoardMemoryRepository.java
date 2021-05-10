package com.example.Capstone.repository;

import com.example.Capstone.domain.Board;
import com.example.Capstone.domain.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BoardMemoryRepository implements BoardRepository{
    private final JdbcTemplate jdbcTemplate;
    private static int sequence;
    @Autowired
    public BoardMemoryRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean addBoard(Board board) {
        String title = board.getTitle();
        String img = board.getImage();
        String contents = board.getContents();
        System.out.println(title+"title");
        // IDX, TITLE, IMG , CONTENTS, WROTE_TIME)
        String sql = "INSERT INTO BOARD VALUES(NULL,?,?,? ,CURRENT_TIMESTAMP)";
        int result = jdbcTemplate.update(sql, title,img,contents);
        System.out.println(result);
        return true;
    }

    @Override
    public List<Board> getEveryBoard() {
        return jdbcTemplate.query("select * from BOARD",boardRowMapper());
    }

    @Override
    public Board getBoardOne(int idx) {
        return null;
    }

    @Override
    public boolean addReply(Reply reply) {
        return false;
    }

    @Override
    public List<Reply> getReply(int boardIdx) {
        return null;
    }

    //idx, title, contents, img
    public RowMapper<Board> boardRowMapper(){
        return (rs, rowNum)-> {
            Board board = new Board(rs.getInt("idx"),rs.getString("title"),rs.getString("contents"),rs.getString("image"));
            return board;
        };
    }
}
