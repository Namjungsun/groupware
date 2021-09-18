package com.groupware.springboot.web.dto;

import com.groupware.springboot.domain.groupwares.GroupWares;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GroupWaresSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public GroupWaresSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public GroupWares toEntity(){
        return GroupWares.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
