package com.example.demo.domain;

import com.example.demo.dto.DefaultDto;
import com.example.demo.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// repository를 만들기 위해서 entity를 만드는 과정.
// DB와의 연결을 위함

@Getter
@Entity // DB 알아서 만들어주고, 내 DB랑 결합해서 사용할 거라는 의미
public class User extends AuditingFields {
    @Setter @Column(unique = true, nullable = false)
    String username;

    @Setter @Column(nullable = false)
    String password;
    @Setter String name;
    @Setter String phone;

    protected User(){}

    private User(Boolean deleted, String username, String password, String name, String phone) {
        this.deleted = deleted;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    public static User of(String username, String password, String name, String phone) {
        return new User(false, username, password, name, phone);
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
