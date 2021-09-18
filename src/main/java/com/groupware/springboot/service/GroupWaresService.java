package com.groupware.springboot.service;

import com.groupware.springboot.domain.groupwares.GroupWares;
import com.groupware.springboot.domain.groupwares.GroupWaresRepository;
import com.groupware.springboot.web.dto.GroupWaresResponseDto;
import com.groupware.springboot.web.dto.GroupWaresSaveRequestDto;
import com.groupware.springboot.web.dto.GroupWaresUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class GroupWaresService {
    private final GroupWaresRepository groupWaresRepository;

    @Transactional
    public Long save(GroupWaresSaveRequestDto requestDto){
        return groupWaresRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, GroupWaresUpdateRequestDto requestDto){
        GroupWares groupWares = groupWaresRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. ID="+ id));

        groupWares.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public GroupWaresResponseDto findById (Long id){
        GroupWares entity = groupWaresRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. ID="+ id));

        return new GroupWaresResponseDto(entity);
    }
}
