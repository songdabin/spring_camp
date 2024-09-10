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
        /*
        컨트롤러 필드에 저장하는 코드 (DB 연결 전)
//        아래의 두 가지 string 변환 방법 모두 사용 가능
        String title = (String) params.get("title");
        String content = params.get("content")+"";
        String author = params.get("author")+"";
        int order = boardList.size();

        Map<String, Object> boardMap = new HashMap<>();
        boardMap.put("order", ++order);
        boardMap.put("title", title);
        boardMap.put("content", content);
        boardMap.put("author", author);
        boardList.add(boardMap);

        System.out.println(boardList);

        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("resultCode", 200);
        */
    }

    @GetMapping("/list")
    public List<Board> list() {
        /*
        DB 연결 전 코드
        return boardList;
        */
        return boardService.listBoard();
    }

    @GetMapping("/detail")
    public Board detail(@RequestParam Integer id) {
        return boardService.detailBoard(id);

        /*
        int index = Integer.parseInt(order) - 1;

        Map<String, Object> boardMap = boardList.get(index);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("result_code", 200);
        resultMap.put("detail_board", boardMap);

        return resultMap;
         */
    }

    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params) {
        /*
        DB 연결 전

        int index = Integer.parseInt(params.get("order") + "") - 1;

        Map<String, Object> boardMap = boardList.get(index);
        boardMap.put("title", params.get("title"));
        boardMap.put("content", params.get("content"));
        boardMap.put("author", params.get("author"));
//        boardList.add()

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("result_code", 200);
//        resultMap.put("detail_board", boardMap);

        return resultMap;
         */
        return boardService.updateBoard(params);
    }

    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params) {
        return boardService.deleteBoard(Integer.parseInt(params.get(("id"))+""));
    }
}
