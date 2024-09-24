package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// repository를 만들기 위해서 entity를 만드는 과정.
// DB와의 연결을 위함

@Setter
@Getter
@Entity // DB 알아서 만들어주고, 내 DB랑 결합해서 사용할 거라는 의미
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id // Primary Key 지정
    Integer id;

    @Column(unique = true, nullable = false)
    String username;

    @Column(nullable = false)
    String password;
    String name;
    String phone;
}
