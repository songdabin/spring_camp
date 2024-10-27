package com.example.demo.controller;

import com.example.demo.domain.Notice;
import com.example.demo.dto.DefaultDto;
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

    @PostMapping("")
    public DefaultDto.CreateResDto create(@RequestBody NoticeDto.CreateReqDto param) {
        return noticeService.create(param);
    }

    @GetMapping("/list")
    public List<NoticeDto.DetailResDto> list(NoticeDto.ListReqDto param) {
        return noticeService.list(param);
    }

    @GetMapping("/detail")
    public NoticeDto.DetailResDto detail(@RequestParam Long id) {
        return noticeService.detail(id);
    }

    @PutMapping("")
    public void update(@RequestBody NoticeDto.UpdateReqDto param) {
        noticeService.update(param);
    }

    @DeleteMapping("")
    public void delete(@RequestBody NoticeDto.UpdateReqDto param) {
        noticeService.delete(param.getId());
    }

    @GetMapping("/pagedList")
    public NoticeDto.PagedListResDto pagedList(NoticeDto.PagedListReqDto param) {
        return noticeService.pagedList(param);
    }
}
