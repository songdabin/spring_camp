package com.example.demo.service;

import com.example.demo.domain.Notice;
import com.example.demo.dto.DefaultDto;
import com.example.demo.dto.NoticeDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface NoticeService {
    DefaultDto.CreateResDto create(NoticeDto.CreateReqDto param);
    List<NoticeDto.DetailResDto> list(NoticeDto.ListReqDto param);
    NoticeDto.PagedListResDto pagedList(NoticeDto.PagedListReqDto param);
    NoticeDto.DetailResDto detail(Long id);
    void update(NoticeDto.UpdateReqDto param);
    Map<String, Object> delete(Long id);
}
