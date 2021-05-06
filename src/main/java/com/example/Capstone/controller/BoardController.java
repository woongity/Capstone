package com.example.Capstone.controller;

import com.example.Capstone.domain.Board;
import com.example.Capstone.service.BoardService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@Controller
public class BoardController {
    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/board")
    public String board() {
        return "board";
    }

    @GetMapping("boardList")
    @ResponseBody
    public List<Board> boardList() {
        return boardService.getEveryBoard();
    }

    @GetMapping("/write")
    public String write() {
        return "write";
    }
    //글작성 api.
    @PostMapping( "/writePost")
    public String writePost(@RequestParam("file") MultipartFile file,@RequestParam("title") String title, @RequestParam("contents")String contents) throws IllegalStateException, IOException {
        String fileName = "/Users/andy/Downloads/Capstone/src/main/resources/files/" + file.getOriginalFilename();
        File targetFile = new File(fileName);
        try {
            InputStream fileStream = file.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);
        } catch (IOException e) {
            FileUtils.deleteQuietly(targetFile);
            e.printStackTrace();
        }
        boardService.addBoard(new Board(0, title, contents,fileName));
        return "board";
    }
}
