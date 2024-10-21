package com.example.demo.mapper;

import com.example.demo.dto.FaqDto;

public interface FaqMapper {
    FaqDto.DetailResDto detail(Long id);
}