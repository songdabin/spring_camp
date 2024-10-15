package com.example.demo.dto;

import com.example.demo.domain.Faq;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class FaqDto {
    @Setter
    @Getter
    public static class CreateReqDto {
        private String title;
        private String content;
        private Long userId;

        public Faq toEntity() {
            /*Faq faq = new Faq();
            faq.setTitle(getTitle());
            faq.setContent(getContent());
            return faq;*/

            return Faq.of(getUserId(), getTitle(), getContent());
        }
    }

    @Setter
    @Getter
    public static class UpdateReqDto {
        private Long id;
        private String title;
        private String content;
    }

    @Builder
    @Setter
    @Getter
    public static class CreateResDto {
        private Long id;
    }

    @Getter
    @Setter
    public static class DetailResDto {
        private Long id;
        private Long userId;
        private String title;
        private String content;
        private String userUsername;
    }
}
