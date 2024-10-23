package com.example.demo.service.impl;

import com.example.demo.domain.Notice;
import com.example.demo.dto.NoticeDto;
import com.example.demo.mapper.NoticeMapper;
import com.example.demo.repository.NoticeRepository;
import com.example.demo.service.NoticeService;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {
    private final NoticeRepository noticeRepository;
    private final NoticeMapper noticeMapper;

    public NoticeServiceImpl(NoticeRepository noticeRepository, NoticeMapper noticeMapper) {
        this.noticeRepository = noticeRepository;
        this.noticeMapper = noticeMapper;
    }

    @Override
    public NoticeDto.CreateResDto create(NoticeDto.CreateReqDto param) {
        /*Notice notice = param.toEntity();
        notice = noticeRepository.save(notice);
        NoticeDto.CreateResDto result = notice.toCreateResDto();
        return result;*/
        return noticeRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(NoticeDto.UpdateReqDto param) {
        Notice notice = noticeRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException(""));

        if(param.getTitle() != null) {
            notice.setTitle(param.getTitle());
        }

        if(param.getContent() != null) {
            notice.setContent(param.getContent());
        }

        noticeRepository.save(notice);
    }

    public NoticeDto.DetailResDto entityToDto(Notice notice) {
        NoticeDto.DetailResDto result = new NoticeDto.DetailResDto();

        result.setId(notice.getId());
        result.setTitle(notice.getTitle());
        result.setContent(notice.getContent());

        return result;
    }

    @Override
    public List<NoticeDto.DetailResDto> list(NoticeDto.ListReqDto param) {
        List<NoticeDto.DetailResDto> list = noticeMapper.list(param);
        return list;
    }

    @Override
    public NoticeDto.DetailResDto detail(Long id) {
        NoticeDto.DetailResDto result = noticeMapper.detail(id);
        return result;
        /*Notice notice = noticeRepository.findById(id).orElseThrow(()-> new RuntimeException(""));

        return entityToDto(notice);*/
    }

    @Override
    public Map<String, Object> delete(Long id) {
        Notice notice = noticeRepository.findById(id).orElseThrow(() -> new RuntimeException(""));

        noticeRepository.delete(notice);

        return null;
    }
}
