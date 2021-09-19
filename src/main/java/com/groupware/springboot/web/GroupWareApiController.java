package com.groupware.springboot.web;

import com.groupware.springboot.service.GroupWaresService;
import com.groupware.springboot.web.dto.GroupWaresResponseDto;
import com.groupware.springboot.web.dto.GroupWaresSaveRequestDto;
import com.groupware.springboot.web.dto.GroupWaresUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class GroupWareApiController {

    private final GroupWaresService groupWaresService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody GroupWaresSaveRequestDto requestDto){
        return  groupWaresService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody GroupWaresUpdateRequestDto requestDto){
        return groupWaresService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public GroupWaresResponseDto findbyId(@PathVariable Long id){
        return groupWaresService.findById(id);
    }

}
