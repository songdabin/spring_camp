package com.example.demo.dto;

import com.example.demo.domain.User;
import lombok.Getter;
import lombok.Setter;

public class UserDto {
    @Setter
    @Getter
    public static class CreateReqDto {
        private String username;
        private String password;
        private String name;
        private String phone;

        public User toEntity() {
            User user = new User();
            user.setUsername(getUsername());
            user.setPassword(getPassword());
            user.setName(getName());
            user.setPhone(getPhone());
            return user;
        }
    }

    @Setter
    @Getter
    public static class CreateResDto {
        private Long id;
    }

    @Setter
    @Getter
    public static class LoginReqDto {
        private String username;
        private String password;
    }

    @Setter
    @Getter
    public static class LoginResDto {
//        private boolean result;
        private Long id;
    }

    @Getter
    @Setter
    public static class UpdateReqDto {
        private long id;
        private String name;
        private String phone;
    }

    @Getter
    @Setter
    public static class DetailResDto {
        private String username;
        private String password;
        private String name;
        private String phone;
    }
}
