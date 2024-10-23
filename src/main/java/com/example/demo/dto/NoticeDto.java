package com.example.demo.dto;

import com.example.demo.domain.Notice;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class NoticeDto {
    @Setter
    @Getter
    public static class CreateReqDto {
        private String title;
        private String content;

        public Notice toEntity() {
            Notice notice = new Notice();
            notice.setTitle(getTitle());
            notice.setContent(getContent());
            return notice;
        }
    }

    @Setter
    @Getter
    public static class UpdateReqDto {
        private Long id;
        private String title;
        private String content;
    }

//    @Builder
    @Setter
    @Getter
    public static class CreateResDto {
        private long id;
    }

    @Getter
    @Setter
    public static class DetailResDto {
        private long id;
        private String title;
        private String content;
    }

    @Getter
    @Setter
    public static class ListReqDto {
        private String title;
    }
}
