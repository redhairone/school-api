package com.ciesielski.schoolapi.presentation.dto.mapper;

import com.ciesielski.schoolapi.domain.model.ChildBill;
import com.ciesielski.schoolapi.presentation.dto.ChildBillDto;

public class ChildBillDtoMapper {
    public static ChildBillDto map(ChildBill input) {
        return ChildBillDto.builder()
                .child(ChildDtoMapper.map(input.getChild()))
                .cost(input.getCost())
                .numberOfPaidHours(input.getNumberOfPaidHours())
                .build();
    }
}
