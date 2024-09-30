package com.example.demo.service;

import com.example.demo.domain.Notice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface NoticeService {
    Map<String, Object> create(Map<String, Object> params);
    List<Notice> list();
    Notice detail(Long id);
    Map<String, Object> update(Map<String, Object> params);
    Map<String, Object> delete(Long id);
}
