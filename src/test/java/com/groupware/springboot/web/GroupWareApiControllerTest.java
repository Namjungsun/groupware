package com.groupware.springboot.web;


import com.groupware.springboot.domain.groupwares.GroupWares;
import com.groupware.springboot.domain.groupwares.GroupWaresRepository;
import com.groupware.springboot.web.dto.GroupWaresSaveRequestDto;
import com.groupware.springboot.web.dto.GroupWaresUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GroupWareApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private GroupWaresRepository groupWaresRepository;

    @After
    public void cleanup() throws Exception{
        groupWaresRepository.deleteAll();
    }

    @Test
    public void 등록된다() throws Exception{
        //given
        String title = "title";
        String content = "content";

        GroupWaresSaveRequestDto requestDto = GroupWaresSaveRequestDto.builder()
                                                .title(title)
                                                .content(content)
                                                .author("author")
                                                .build();

        String url = "http://localhost:" + port + "/api/v1/posts";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        //List<GroupWares> all = GroupWaresRepository.findAll();

        //assertThat(all.get(0).getTitle()).isEqualTo(title);
        //assertThat(all.get(0).getContent()).isEqualTo(content);
    }

    @Test
    public void 수정된다() throws Exception{
        //given
        GroupWares saveGroupWares = groupWaresRepository.save(GroupWares.builder()
                                                            .title("title")
                                                            .content("content")
                                                            .author("author")
                                                            .build());

        Long updateId = saveGroupWares.getId();
        String expectedTitle = "title2";
        String expectedContent = "content2";

        GroupWaresUpdateRequestDto requestDto = GroupWaresUpdateRequestDto.builder()
                .title(expectedTitle)
                .content(expectedContent)
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts/" + updateId;

        HttpEntity<GroupWaresUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        //List<GroupWares> all = GroupWaresRepository.findAll();

        //assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        //assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
    }



}