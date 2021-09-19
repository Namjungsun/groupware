package com.groupware.springboot.web;

import com.groupware.springboot.domain.groupwares.GroupWares;
import com.groupware.springboot.domain.groupwares.GroupWaresRepository;
import com.groupware.springboot.service.GroupWaresService;
import com.groupware.springboot.web.dto.GroupWaresResponseDto;
import com.groupware.springboot.web.dto.GroupWaresSaveRequestDto;
import com.groupware.springboot.web.dto.GroupWaresUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GroupWareApiController {

    private final GroupWaresService groupWaresService;

    @PostMapping("/org/member")
    public Long save(@RequestBody GroupWaresSaveRequestDto requestDto){
        return  groupWaresService.save(requestDto);
    }

    @PutMapping("/org/member/{memberId}")
    public Long update(@PathVariable Long memberId, @RequestBody GroupWaresUpdateRequestDto requestDto){
        return groupWaresService.update(memberId, requestDto);
    }

    @GetMapping("/org/organizations/{memberId}")
    public GroupWaresResponseDto findbyId(@PathVariable Long memberId){
        return groupWaresService.findById(memberId);
    }

    @GetMapping("/org/organizations")
    public List<GroupWares> getMemberList(){
        return groupWaresService.findAll();
    }

    @DeleteMapping("/org/member/{memberId}")
    public void deleteMember(@PathVariable Long memberId) {
        groupWaresService.delete(memberId);
    }
}
