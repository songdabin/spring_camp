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

    @Setter @Column(nullable = false)
    String title;

    @Setter
    String content;

    // 생성자는 아무도 사용하지 못하게 하려고
    // of method를 통해서만 entity instance를 생성
    protected Faq() {}
    private Faq(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static Faq of(String title, String content) {
        return new Faq(title, content);
    }

    public FaqDto.CreateResDto toCreateResDto() {
        /*FaqDto.CreateResDto dto = new FaqDto.CreateResDto();
        dto.setId(getId());
        return dto;*/

         return FaqDto.CreateResDto.builder().id(id).build();
    }
}
