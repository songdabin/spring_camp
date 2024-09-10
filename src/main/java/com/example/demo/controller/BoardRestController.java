package com.example.demo.controller;

import com.example.demo.domain.Board;
import com.example.demo.service.BoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/board")
@RestController
public class BoardRestController {
    private final BoardService boardService;
    public BoardRestController (BoardService boardService) {
        this.boardService = boardService;
    }

    List<Map<String, Object>> boardList = new ArrayList<>();
    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params) {
        return boardService.createBoard(params);
    }

    @GetMapping("/list")
    public List<Board> list() {
        return boardService.listBoard();
    }

    @GetMapping("/detail")
    public Board detail(@RequestParam Integer id) {
        return boardService.detailBoard(id);
    }

    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params) {
        return boardService.updateBoard(params);
    }

    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params) {
        return boardService.deleteBoard(Integer.parseInt(params.get(("id"))+""));
    }
}
