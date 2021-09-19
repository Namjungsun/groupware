package com.groupware.springboot.web;


import com.groupware.springboot.domain.groupwares.GroupWares;
import com.groupware.springboot.domain.groupwares.GroupWaresRepository;
import com.groupware.springboot.web.dto.GroupWaresSaveRequestDto;
import com.groupware.springboot.web.dto.GroupWaresUpdateRequestDto;
import org.aspectj.lang.annotation.After;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GroupWareApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private GroupWaresRepository groupWaresRepository;
/*
    @AfterEach
    public void cleanup() throws Exception{
        groupWaresRepository.deleteAll();
    }
*/
    @Test
    public void TEST_등록된다() throws Exception{
        //given
        String type = "Member";
        String name = "박지성";
        String code = "002";

        GroupWaresSaveRequestDto requestDto = GroupWaresSaveRequestDto.builder()
                                                .type(type)
                                                .name(name)
                                                .code(code)
                                                .build();

        String url = "http://localhost:" + port + "/org/member";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<GroupWares> all = groupWaresRepository.findAll();

        assertThat(all.get(0).getType()).isEqualTo(type);
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getCode()).isEqualTo(code);
    }


    @Test
    public void TEST_수정된다() throws Exception{
        //given
        GroupWares saveGroupWares = groupWaresRepository.save(GroupWares.builder()
                                                            .type("type")
                                                            .name("name")
                                                            .code("code")
                                                            .build());

        Long updateId = saveGroupWares.getId();

        String type = "Member";
        String name = "손흥민";
        String code = "003";

        GroupWaresUpdateRequestDto requestDto = GroupWaresUpdateRequestDto.builder()
                .type(type)
                .name(name)
                .code(code)
                .build();

        String url = "http://localhost:" + port + "/org/member/" + updateId;

        HttpEntity<GroupWaresUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<GroupWares> all = groupWaresRepository.findAll();

        assertThat(all.get(0).getType()).isEqualTo(type);
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getCode()).isEqualTo(code);
    }
}
