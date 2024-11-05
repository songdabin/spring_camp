package com.example.demo.service;

import com.example.demo.dto.DefaultDto;
import com.example.demo.dto.FaqDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FaqService {
    DefaultDto.CreateResDto create(FaqDto.CreateReqDto param);
    void update(FaqDto.UpdateReqDto param);
    void delete(Long id);
    FaqDto.DetailResDto detail(Long id);
    List<FaqDto.DetailResDto> list(FaqDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(FaqDto.PagedListReqDto param);
    List<FaqDto.DetailResDto> scrollList(FaqDto.ScrollListReqDto param);
}
