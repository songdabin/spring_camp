package com.example.demo.service.impl;

import com.example.demo.domain.Notice;
import com.example.demo.dto.NoticeDto;
import com.example.demo.repository.NoticeRepository;
import com.example.demo.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {
    private final NoticeRepository noticeRepository;
    public NoticeServiceImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public NoticeDto.CreateResDto create(NoticeDto.CreateReqDto param) {
//        Map<String, Object> result = new HashMap<String, Object>();

//        Notice notice = new Notice();
//
//        notice.setTitle(param.getTitle());
//        notice.setContent(param.getContent());
//        noticeRepository.save(notice);

//        result.put("success", true);
//        result.put("id", notice.getId());
//
//        return result;

        Notice notice = param.toEntity();
        notice = noticeRepository.save(notice);
        NoticeDto.CreateResDto result = notice.toCreateResDto();
        return result;
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


    @Override
    public List<Notice> list() {
        return noticeRepository.findAll();
    }

    @Override
    public Notice detail(Long id) {
        return noticeRepository.findById(id).orElseThrow(()-> new RuntimeException(""));
    }

//    @Override
//    public Map<String, Object> update(Map<String, Object> params) {
//        Notice notice = noticeRepository.findById(Long.parseLong(params.get("id") + "")).orElseThrow(() -> new RuntimeException(""));
//
//        if(params.get("title")!=null) {
//            notice.setTitle((String) params.get("title"));
//        }
//
//        if(params.get("content")!=null) {
//            notice.setContent((String) params.get("content"));
//        }
//
//        noticeRepository.save(notice);
//
//        return null;
//    }

    @Override
    public Map<String, Object> delete(Long id) {
        Notice notice = noticeRepository.findById(id).orElseThrow(() -> new RuntimeException(""));

        noticeRepository.delete(notice);

        return null;
    }
}
