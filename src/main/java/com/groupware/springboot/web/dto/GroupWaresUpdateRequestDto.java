package com.groupware.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GroupWaresUpdateRequestDto {
    private String type ;
    private String name ;
    private String code ;

    @Builder
    public GroupWaresUpdateRequestDto(String type, String name, String code){
        this.type = type;
        this.name = name;
        this.code = code;
    }
}
