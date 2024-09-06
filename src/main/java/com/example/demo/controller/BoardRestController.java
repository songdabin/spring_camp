package com.example.demo.controller;

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
    List<Map<String, Object>> boardList = new ArrayList<>();
    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params) {
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

        return resultMap;
    }

    @GetMapping("/list")
    public List<Map<String, Object>> list() {
        return boardList;
    }

    @GetMapping("/detail")
    public Map<String, Object> detail(@RequestParam String order) {
        int index = Integer.parseInt(order) - 1;
        Map<String, Object> boardMap = boardList.get(index);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("result_code", 200);
        resultMap.put("detail_board", boardMap);

        return resultMap;
    }
}
