package com.example.demo.service;

import com.example.demo.dto.DefaultDto;
import com.example.demo.dto.NoticeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoticeService {
    /**/
    DefaultDto.CreateResDto create(NoticeDto.CreateReqDto param);
    void update(NoticeDto.UpdateReqDto param);
    void delete(Long id);
    void deletes(DefaultDto.DeletesReqDto param);
    NoticeDto.DetailResDto detail(Long id);
    List<NoticeDto.DetailResDto> list(NoticeDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(NoticeDto.PagedListReqDto param);
    List<NoticeDto.DetailResDto> scrollList(NoticeDto.ScrollListReqDto param);

}