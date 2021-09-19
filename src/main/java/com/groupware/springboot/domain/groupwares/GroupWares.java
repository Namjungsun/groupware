package com.groupware.springboot.domain.groupwares;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class GroupWares {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type ;
    private String name ;
    private String code ;

    @Builder
    public GroupWares(String type, String name, String code){
        this.type = type;
        this.name = name;
        this.code = code;
    }

    public void update(String type, String name, String code){
        this.type = type;
        this.name = name;
        this.code = code;
    }
}
