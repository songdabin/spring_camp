package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

// repository를 만들기 위해서 entity를 만드는 과정.
// DB와의 연결을 위함

@Setter
@Getter
@Entity // DB 알아서 만들어주고, 내 DB랑 결합해서 사용할 거라는 의미
public class Board {
    @Id // Primary Key 지정
    Integer id;

    String title;
    String content;
    String author;
}
