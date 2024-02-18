package com.ciesielski.schoolapi.presentation.dto.mapper;

import com.ciesielski.schoolapi.domain.model.bill.ParentBill;
import com.ciesielski.schoolapi.presentation.dto.ChildBillDto;
import com.ciesielski.schoolapi.presentation.dto.ParentBillDto;

import java.util.List;

public class ParentBillDtoMapper {
    public static ParentBillDto map(ParentBill input) {
        final List<ChildBillDto> childrenBillsDto = input.getChildrenBills().stream()
                .map(ChildBillDtoMapper::map)
                .toList();

        return ParentBillDto.builder()
                .parent(input.getParent())
                .childrenBills(childrenBillsDto)
                .fullCost(input.getParentCost())
                .build();
    }
}
