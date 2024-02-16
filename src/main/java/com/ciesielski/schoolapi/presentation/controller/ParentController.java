package com.ciesielski.schoolapi.presentation.controller;

import com.ciesielski.schoolapi.domain.model.ParentBill;
import com.ciesielski.schoolapi.domain.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParentController {

    private final ParentService parentService;

    @Autowired
    public ParentController(final ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping(path = "/getParentBillForMonth")
    public ParentBill getParentBillForMonth(@RequestParam final Long id, final int month) {
        return parentService.getParentBillForMonth(id, month);
    }
}
