package com.example.demo.dto;

import com.example.demo.domain.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

public class UserDto {
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class CreateReqDto extends DefaultDto.CreateReqDto{
        private String username;
        private String password;
        private String name;
        private String phone;

        public User toEntity() {
            return User.of(getUsername(), getPassword(), getName(), getPhone());
        }
    }

    /*
    @AllArgsConstructor @NoArgsConstructor @Setter @Getter
    public static class CreateResDto {
        private Long id;
    }
    */

    @AllArgsConstructor @NoArgsConstructor @Builder @Setter @Getter
    public static class LoginReqDto {
        private String username;
        private String password;
    }

    @AllArgsConstructor @NoArgsConstructor @Setter @Getter
    public static class LoginResDto {
//        private boolean result;
        private Long id;
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {
        private String name;
        private String phone;
    }

    @AllArgsConstructor @NoArgsConstructor @Setter @Getter
    public static class DetailResDto extends DefaultDto.DetailResDto {
        private String username;
        private String password;
        private String name;
        private String phone;
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class ListReqDto extends DefaultDto.ListReqDto {
        private String username;
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class PagedListReqDto extends DefaultDto.PagedListReqDto {
        private String username;
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class ScrollListReqDto extends DefaultDto.ScrollListReqDto {
        private String username;
    }
}
