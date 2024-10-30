package com.example.demo.mapper;

import com.example.demo.dto.FaqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FaqMapper {
    FaqDto.DetailResDto detail(Long id);
    List<FaqDto.DetailResDto> list(FaqDto.ListReqDto param);
    List<FaqDto.DetailResDto> pagedList(FaqDto.PagedListReqDto param);
    int pagedListCount(FaqDto.PagedListReqDto param);
}