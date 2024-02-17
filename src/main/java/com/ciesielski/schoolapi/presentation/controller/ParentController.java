package com.ciesielski.schoolapi.presentation.controller;

import com.ciesielski.schoolapi.domain.service.ParentService;
import com.ciesielski.schoolapi.presentation.dto.ParentBillDto;
import com.ciesielski.schoolapi.presentation.dto.mapper.ParentBillDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ParentController {

    private final ParentService parentService;

    @GetMapping(path = "/getParentBillForMonth")
    public ParentBillDto getParentBillForMonth(@RequestParam final Long id, final int month) {
        return ParentBillDtoMapper.map(
                parentService.getParentBillForMonth(id, month)
        );
    }
}
