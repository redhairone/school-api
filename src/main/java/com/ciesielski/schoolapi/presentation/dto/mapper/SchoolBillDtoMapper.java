package com.ciesielski.schoolapi.presentation.dto.mapper;

import com.ciesielski.schoolapi.domain.model.bill.SchoolBill;
import com.ciesielski.schoolapi.presentation.dto.ParentBillDto;
import com.ciesielski.schoolapi.presentation.dto.SchoolBillDto;

import java.math.RoundingMode;
import java.util.List;

public class SchoolBillDtoMapper {

    public static SchoolBillDto map(SchoolBill input) {
        final List<ParentBillDto> parentBillDtos = input.getParentBills().stream()
                .map(ParentBillDtoMapper::map)
                .toList();

        return SchoolBillDto.builder()
                .school(input.getSchool())
                .parentBills(parentBillDtos)
                .fullProfit(input.getSchoolProfit().setScale(2, RoundingMode.CEILING))
                .build();
    }
}
