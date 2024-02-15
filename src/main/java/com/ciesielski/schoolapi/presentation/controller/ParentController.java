package com.ciesielski.schoolapi.presentation.controller;

import com.ciesielski.schoolapi.presentation.dto.ParentBill;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParentController {

    @GetMapping(path = "/getParentBillForMonth")
    public ParentBill getParentBillForMonth(@RequestParam final Long id, final int month) {
        throw new NotImplementedException();
    }
}
