package com.groupware.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GroupWaresUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public GroupWaresUpdateRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
