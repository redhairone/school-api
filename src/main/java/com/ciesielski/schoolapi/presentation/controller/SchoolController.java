package com.ciesielski.schoolapi.presentation.controller;

import com.ciesielski.schoolapi.domain.service.SchoolService;
import com.ciesielski.schoolapi.presentation.dto.SchoolBillDto;
import com.ciesielski.schoolapi.presentation.dto.mapper.SchoolBillDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping(path = "/getSchoolBillForMonth")
    public SchoolBillDto getSchoolBillForMonth(@RequestParam(required = true) final Long id, final int month) {
        return SchoolBillDtoMapper.map(
                schoolService.getSchoolBillForMonth(id, month)
        );
    }
}
