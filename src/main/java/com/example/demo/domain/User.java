package com.example.demo.domain;

import com.example.demo.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// repository를 만들기 위해서 entity를 만드는 과정.
// DB와의 연결을 위함

@Getter
@Entity // DB 알아서 만들어주고, 내 DB랑 결합해서 사용할 거라는 의미
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id // Primary Key 지정
    Long id;

    @Setter @Column(unique = true, nullable = false)
    String username;

    @Setter @Column(nullable = false)
    String password;
    @Setter String name;
    @Setter String phone;

    public UserDto.CreateResDto toCreateResDto() {
        UserDto.CreateResDto result = new UserDto.CreateResDto();
        result.setId(getId());

        return result;
    }
}
