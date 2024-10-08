package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto.CreateResDto create(UserDto.CreateReqDto param) {
        System.out.println("create");

        User user = userRepository.findByUsername(param.getUsername());
        if (user != null) {
            throw new RuntimeException("id exist");
        }

        return userRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User detail(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException(""));
    }

    @Override
    public Map<String, Object> update(Map<String, Object> params) {
        System.out.println("update");

        User user = userRepository.findById(Long.parseLong(params.get("id") + "")).orElseThrow(() -> new RuntimeException(""));

        if(params.get("username")!=null) {
            user.setUsername((String) params.get("username"));
        }

        if(params.get("password")!=null) {
            user.setPassword((String) params.get("password"));
        }

        if(params.get("name")!=null) {
            user.setName((String) params.get("name"));
        }

        if(params.get("phone")!=null) {
            user.setPhone((String) params.get("phone"));
        }

        userRepository.save(user);

        return null;
    }

    @Override
    public Map<String, Object> delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(""));

        userRepository.delete(user);

        return null;
    }

    @Override
    public UserDto.LoginResDto login(UserDto.LoginReqDto param) {
        String username = param.getUsername();
        String password = param.getPassword();
        User user = userRepository.findByUsernameAndPassword(username, password);
        if(user == null){
            throw new RuntimeException("id password not matched");
        }
        UserDto.LoginResDto res = new UserDto.LoginResDto();
        res.setResult(true);
        return res;
    }

    @Override
    public UserDto.CreateResDto signup(UserDto.CreateReqDto param) {
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
}
