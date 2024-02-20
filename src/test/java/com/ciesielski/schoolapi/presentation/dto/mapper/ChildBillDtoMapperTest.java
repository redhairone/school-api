package com.ciesielski.schoolapi.presentation.dto.mapper;

import com.ciesielski.schoolapi.domain.model.Child;
import com.ciesielski.schoolapi.domain.model.bill.ChildBill;
import com.ciesielski.schoolapi.presentation.dto.ChildBillDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

class ChildBillDtoMapperTest {

    @Test
    void shouldMapCorrectlyTest() {
        //GIVEN:
        final Child child = new Child(1L, "", "", null, null);
        final BigDecimal childCost = BigDecimal.TEN;
        final Long numberOfPaidHours = 5L;

        final ChildBill childBill = Mockito.mock(ChildBill.class);
        Mockito.when(childBill.getChild()).thenReturn(child);
        Mockito.when(childBill.getChildCost()).thenReturn(childCost);
        Mockito.when(childBill.getNumberOfPaidHours()).thenReturn(numberOfPaidHours);

        //WHEN:
        final ChildBillDto childBillDto = ChildBillDtoMapper.map(childBill);

        //THEN:
        Assertions.assertNotNull(childBillDto);
        Assertions.assertEquals(childCost, childBillDto.getCost());
        Assertions.assertEquals(numberOfPaidHours, childBillDto.getNumberOfPaidHours());
    }

}