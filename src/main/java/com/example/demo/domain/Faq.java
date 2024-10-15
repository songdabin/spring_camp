package com.example.demo.domain;

import com.example.demo.dto.FaqDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Faq {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id long id;

    @Setter
    Long userId;

    @Setter @Column(nullable = false)
    String title;

    @Setter
    String content;

    // 생성자는 아무도 사용하지 못하게 하려고
    // of method를 통해서만 entity instance를 생성
    protected Faq() {}
    private Faq(Long userId, String title, String content) {
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    public static Faq of(Long userId, String title, String content) {
        return new Faq(userId, title, content);
    }

    public FaqDto.CreateResDto toCreateResDto() {
        /*FaqDto.CreateResDto dto = new FaqDto.CreateResDto();
        dto.setId(getId());
        return dto;*/

         return FaqDto.CreateResDto.builder().id(id).build();
    }
}
