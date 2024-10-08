package com.example.demo.domain;

import com.example.demo.dto.NoticeDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Notice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id long id;

    @Setter @Column(nullable = false)
    String title;

    @Setter
    String content;

    public NoticeDto.CreateResDto toCreateResDto() {
        NoticeDto.CreateResDto dto = new NoticeDto.CreateResDto();
        dto.setId(getId());
        return dto;

        // Builder annotation을 NoticeDto.CreateResDto에 붙여둔 경우에 다음과 같이 사용가능
        // return NoticeDto.CreateResDto.builder().id(id).build();
    }
}
