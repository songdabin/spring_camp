package com.example.demo.service;

import com.example.demo.dto.FaqDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FaqService {
    FaqDto.CreateResDto create(FaqDto.CreateReqDto param);
    List<FaqDto.DetailResDto> list(FaqDto.ListReqDto param);
    FaqDto.DetailResDto detail(Long id);
    void update(FaqDto.UpdateReqDto param);
    void delete(Long id);
}
