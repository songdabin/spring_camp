package com.example.demo.domain;

import com.example.demo.dto.DefaultDto;
import com.example.demo.dto.NoticeDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Notice extends AuditingFields{
    @Setter @Column(nullable = false)
    String title;

    @Setter
    String content;

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
