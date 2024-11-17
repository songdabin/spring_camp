package com.example.demo.mapper;

import com.example.demo.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    NoticeDto.DetailResDto detail(Long id);
    List<NoticeDto.DetailResDto> list(NoticeDto.ListReqDto param);
    List<NoticeDto.DetailResDto> pagedList(NoticeDto.PagedListReqDto param);
    int pagedListCount(NoticeDto.PagedListReqDto param);
    List<NoticeDto.DetailResDto> scrollList(NoticeDto.ScrollListReqDto param);
}