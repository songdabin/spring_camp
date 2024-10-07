package com.example.demo.controller;

import com.example.demo.domain.Notice;
import com.example.demo.dto.NoticeDto;
import com.example.demo.service.NoticeService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/notice")
@RestController
public class NoticeRestController {
    private final NoticeService noticeService;
    public NoticeRestController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @PostMapping("/create")
    public NoticeDto.CreateResDto create(@RequestBody NoticeDto.CreateReqDto param) {
//        Map<String, Object> params = new HashMap<>();
//        params.put("title", param.getTitle());
//        params.put("content", param.getContent());
        return noticeService.create(param);
    }

    /*
    @GetMapping("/create")
    public Map<String, Object> create(@RequestParam Map<String, Object> params) {
        return noticeService.create(params);
    }
     */

    @GetMapping("/list")
    public List<Notice> list() {
        return noticeService.list();
    }

    @GetMapping("/detail")
    public Notice detail(@RequestParam Long id) {
        return noticeService.detail(id);
    }

//    @GetMapping("/update")
//    public void update(@RequestParam Map<String, Object> params) {
//        noticeService.update(params);
//    }

    @PutMapping("/update")
    public void update(@RequestBody NoticeDto.UpdateReqDto param) {
        noticeService.update(param);
    }

    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params) {
        return noticeService.delete(Long.parseLong(params.get(("id")) + ""));
    }
}
