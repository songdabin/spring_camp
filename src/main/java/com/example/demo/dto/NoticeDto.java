package com.example.demo.dto;

import com.example.demo.domain.Notice;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.SuperBuilder;

public class NoticeDto {
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class CreateReqDto extends DefaultDto.CreateReqDto{
        private String title;
        private String content;

        public Notice toEntity() {
            Notice notice = new Notice();
            notice.setDeleted(false);
            notice.setTitle(getTitle());
            notice.setContent(getContent());
            return notice;
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {
        private String title;
        private String content;
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    public static class DetailResDto extends DefaultDto.DetailResDto{
        private String title;
        private String content;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Getter
    @Setter
    public static class ListReqDto extends DefaultDto.ListReqDto {
        private String title;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class PagedListReqDto {
        private Boolean deleted;
        private String title;
        private int callpage;
        private int nowpage;

        private Integer perpage; //한페이지에 몇개 보여줄지
        private Integer offset; //몇번째 정보부터 보여줄지
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class PagedListResDto {
        private int countList;
        private int callpage;
        private int countPage;
        private Object list;
    }
}
