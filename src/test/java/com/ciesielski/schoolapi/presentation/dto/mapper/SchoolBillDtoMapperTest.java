package com.ciesielski.schoolapi.presentation.dto.mapper;

import com.ciesielski.schoolapi.domain.model.School;
import com.ciesielski.schoolapi.domain.model.bill.SchoolBill;
import com.ciesielski.schoolapi.presentation.dto.SchoolBillDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Collections;

class SchoolBillDtoMapperTest {

    @Test
    void shouldMapCorrectlyTest() {
        //GIVEN:
        final School school = new School(1L, "", BigDecimal.TEN);
        final BigDecimal schoolProfit = BigDecimal.TEN;
        final Long numberOfPaidHours = 5L;

        final SchoolBill schoolBill = Mockito.mock(SchoolBill.class);
        Mockito.when(schoolBill.getSchool()).thenReturn(school);
        Mockito.when(schoolBill.getSchoolProfit()).thenReturn(schoolProfit);
        Mockito.when(schoolBill.getParentBills()).thenReturn(Collections.emptyList());

        //WHEN:
        final SchoolBillDto schoolBillDto = SchoolBillDtoMapper.map(schoolBill);

        //THEN:
        Assertions.assertNotNull(schoolBillDto);
        Assertions.assertEquals(school, schoolBillDto.getSchool());
        Assertions.assertEquals(schoolProfit, schoolBillDto.getFullProfit());
        Assertions.assertEquals(0, schoolBillDto.getParentBills().size());
    }
}