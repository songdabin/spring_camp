package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    UserDto.LoginResDto login(UserDto.LoginReqDto param);
    UserDto.CreateResDto signup(UserDto.CreateReqDto param);
    boolean check(String username);

    UserDto.CreateResDto create(UserDto.CreateReqDto param);
    List<User> list();
    User detail(Long id);
    Map<String, Object> update(Map<String, Object> params);
    Map<String, Object> delete(Long id);
}
