package com.groupware.springboot.web.dto;

import com.groupware.springboot.domain.groupwares.GroupWares;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GroupWaresSaveRequestDto {
    private String type ;
    private String name ;
    private String code ;

    @Builder
    public GroupWaresSaveRequestDto(String type, String name, String code){
        this.type = type;
        this.name = name;
        this.code = code;
    }

    public GroupWares toEntity(){
        return GroupWares.builder()
                .type(type)
                .name(name)
                .code(code)
                .build();
    }

}
