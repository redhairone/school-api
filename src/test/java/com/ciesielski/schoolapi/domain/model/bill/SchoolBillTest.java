package com.ciesielski.schoolapi.domain.model.bill;

import com.ciesielski.schoolapi.domain.exceptions.bill.SchoolBillException;
import com.ciesielski.schoolapi.domain.model.Child;
import com.ciesielski.schoolapi.domain.model.School;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class SchoolBillTest {

    public static Stream<Arguments> provideSchoolProfitCalculationTest() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(15), BigDecimal.valueOf(15), BigDecimal.valueOf(32.5), BigDecimal.valueOf(62.5)),
                Arguments.of(BigDecimal.valueOf(10), BigDecimal.valueOf(8), BigDecimal.valueOf(12), BigDecimal.valueOf(30)),
                Arguments.of(BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(10), BigDecimal.valueOf(10))
        );
    }

    @ParameterizedTest
    @MethodSource("provideSchoolProfitCalculationTest")
    void schoolProfitCalculationTest(final BigDecimal firstParentCost,
                                     final BigDecimal secondParentCost,
                                     final BigDecimal thirdParentCost,
                                     final BigDecimal fullCost) throws SchoolBillException {
        // GIVEN:
        List<ParentBill> parentBills = List.of(
                mockParentBill(firstParentCost, List.of(mockChildBill())),
                mockParentBill(secondParentCost, List.of(mockChildBill())),
                mockParentBill(thirdParentCost, List.of(mockChildBill()))
        );

        // WHEN:
        SchoolBill schoolBill = SchoolBill.createSchoolBill(parentBills);

        // THEN:
        Assertions.assertEquals(fullCost, schoolBill.getSchoolProfit());
    }

    @Test
    void createEmptySchoolBillTest() {
        // GIVEN:
        final School school = new School(0L, "", BigDecimal.ZERO);

        // WHEN:
        final SchoolBill schoolBill = SchoolBill.createEmptySchoolBill(school);

        // THEN:
        Assertions.assertEquals(school, schoolBill.getSchool());
        Assertions.assertEquals(0, schoolBill.getParentBills().size());
        Assertions.assertEquals(BigDecimal.ZERO, schoolBill.getSchoolProfit());
    }

    @Test
    void createSchoolBillFromEmptyParentBills() {
        // WHEN/THEN:
        Assertions.assertThrows(
                SchoolBillException.class,
                () -> SchoolBill.createSchoolBill(Collections.emptyList())
        );
    }

    private ChildBill mockChildBill() {
        final School school = new School(0L, "", BigDecimal.ZERO);
        final Child child = new Child(0L, "", "", null, school);
        final ChildBill childBill = Mockito.mock(ChildBill.class);

        Mockito.when(childBill.getChild()).thenReturn(child);

        return childBill;
    }

    private ParentBill mockParentBill(final BigDecimal parentCost, final List<ChildBill> childrenBill) {
        final ParentBill parentBill = Mockito.mock(ParentBill.class);
        Mockito.when(parentBill.getChildrenBills()).thenReturn(childrenBill);
        Mockito.when(parentBill.getParentCost()).thenReturn(parentCost);
        return parentBill;
    }
}
