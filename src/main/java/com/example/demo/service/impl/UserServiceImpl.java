package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.dto.DefaultDto;
import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**/

    @Override
    public UserDto.LoginResDto login(UserDto.LoginReqDto param) {
        String username = param.getUsername();
        String password = param.getPassword();
        User user = userRepository.findByUsernameAndPassword(username, password);
        if(user == null){
            throw new RuntimeException("id password not matched");
        }
        UserDto.LoginResDto res = new UserDto.LoginResDto();
//        res.setResult(true);
        res.setId(user.getId());
        return res;
    }

    @Override
    public DefaultDto.CreateResDto signup(UserDto.CreateReqDto param) {
        if(param.getUsername() == null || param.getPassword() == null || param.getName() == null || param.getPhone() == null){
            throw new RuntimeException("not enough parameters");
        }
        return create(param);
    }

    @Override
    public boolean check(String username) {
        User user = userRepository.findByUsername(username);

        if (user != null){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public DefaultDto.CreateResDto create(UserDto.CreateReqDto param) {
        User user = userRepository.findByUsername(param.getUsername());
        if (user != null) {
            throw new RuntimeException("id exist");
        }

        return userRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(UserDto.UpdateReqDto param) {
        User user = userRepository.findById(Long.parseLong(param.getId() + "")).orElseThrow(() -> new RuntimeException(""));

        /*if(param.get!=null) {
            user.setUsername((String) param.get("username"));
        }

        if(param.get("password")!=null) {
            user.setPassword((String) param.get("password"));
        }*/

        if(param.getName() != null) {
            user.setName(param.getName());
        }

        if(param.getPhone() != null) {
            user.setPhone(param.getPhone());
        }

        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(""));

        userRepository.delete(user);
    }

    public UserDto.DetailResDto get(Long id) {
        return userMapper.detail(id);
    }

    public List<UserDto.DetailResDto> detailList(List<UserDto.DetailResDto> list) {
        List<UserDto.DetailResDto> rtnVal = new ArrayList<>();

        for (UserDto.DetailResDto each : list) {
            rtnVal.add(get(each.getId()));
        }
        return rtnVal;
    }

    @Override
    public UserDto.DetailResDto detail(Long id) {
        return get(id);
    }

    @Override
    public List<UserDto.DetailResDto> list(UserDto.ListReqDto param) {
        return detailList(userMapper.list(param));
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(UserDto.PagedListReqDto param) {
        DefaultDto.PagedListResDto returnVal = DefaultDto.PagedListResDto.init(param, userMapper.pagedListCount(param));
        returnVal.setList(detailList(userMapper.pagedList(param)));
        return returnVal;
    }

    @Override
    public List<UserDto.DetailResDto> scrollList(UserDto.ScrollListReqDto param) {
        param.init();
        Long cursor = param.getCursor();
        if (cursor != null) {
            User user = userRepository.findById(cursor).orElseThrow(() -> new RuntimeException(""));
            param.setCreatedAt(user.getCreatedAt() + "");
        }
        return detailList(userMapper.scrollList(param));
    }
}
