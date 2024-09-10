package com.example.demo.service;

import com.example.demo.domain.Board;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BoardService {
    Map<String, Object> createBoard(Map<String, Object> params);
    List<Board> listBoard();
    Board detailBoard(Integer id);
    Map<String, Object> updateBoard(Map<String, Object> params);
    Map<String, Object> deleteBoard(Integer id);
}
