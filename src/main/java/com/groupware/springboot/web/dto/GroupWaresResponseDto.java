package com.groupware.springboot.web.dto;

import com.groupware.springboot.domain.groupwares.GroupWares;
import lombok.Getter;

@Getter
public class GroupWaresResponseDto {

    private Long id;
    private String type ;
    private String name ;
    private String code ;

    public GroupWaresResponseDto(GroupWares entity){
        this.id = entity.getId();
        this.type = entity.getType();
        this.name = entity.getName();
        this.code = entity.getCode();
    }
}
