package com.ciesielski.schoolapi.presentation.dto.mapper;

import com.ciesielski.schoolapi.domain.model.Parent;
import com.ciesielski.schoolapi.domain.model.bill.ChildBill;
import com.ciesielski.schoolapi.domain.model.bill.ParentBill;
import com.ciesielski.schoolapi.presentation.dto.ParentBillDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

class ParentBillDtoMapperTest {

    @Test
    void shouldMapCorrectlyTest() {
        //GIVEN:
        final Parent parent = new Parent(1L, "", "");
        final BigDecimal parentCost = BigDecimal.TEN;
        final List<ChildBill> childrenBills = Collections.emptyList();

        final ParentBill parentBill = Mockito.mock(ParentBill.class);
        Mockito.when(parentBill.getParent()).thenReturn(parent);
        Mockito.when(parentBill.getParentCost()).thenReturn(parentCost);
        Mockito.when(parentBill.getChildrenBills()).thenReturn(childrenBills);

        //WHEN:
        final ParentBillDto parentBillDto = ParentBillDtoMapper.map(parentBill);

        //THEN:
        Assertions.assertNotNull(parentBillDto);
        Assertions.assertEquals(parent, parentBillDto.getParent());
        Assertions.assertEquals(parentCost, parentBillDto.getFullCost());
        Assertions.assertEquals(0, parentBillDto.getChildrenBills().size());
    }
}