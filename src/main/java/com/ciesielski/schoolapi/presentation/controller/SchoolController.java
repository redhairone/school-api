package com.ciesielski.schoolapi.presentation.controller;

import com.ciesielski.schoolapi.domain.model.ParentBill;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SchoolController {

    @GetMapping(path = "/getSchoolBillForMonth")
    public List<ParentBill> getSchoolBillForMonth(@RequestParam(required = true) final Long id, final int month) {
        throw new NotImplementedException("Not implemented yet");
    }
}
