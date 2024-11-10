package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.DefaultDto;
import com.example.demo.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    UserDto.LoginResDto login(UserDto.LoginReqDto param);
    DefaultDto.CreateResDto signup(UserDto.CreateReqDto param);
    boolean check(String username);

    DefaultDto.CreateResDto create(UserDto.CreateReqDto param);
    void update(UserDto.UpdateReqDto param);
    void delete(Long id);
    UserDto.DetailResDto detail(Long id);
    List<UserDto.DetailResDto> list(UserDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(UserDto.PagedListReqDto param);
    List<UserDto.DetailResDto> scrollList(UserDto.ScrollListReqDto param);
}
