package com.groupware.springboot.web.dto;

import com.groupware.springboot.domain.groupwares.GroupWares;
import lombok.Getter;

@Getter
public class GroupWaresResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public GroupWaresResponseDto(GroupWares entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
