package com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    Map<String, Object> create(Map<String, Object> params);
    List<User> list();
    User detail(Integer id);
    Map<String, Object> update(Map<String, Object> params);
    Map<String, Object> delete(Integer id);
}
