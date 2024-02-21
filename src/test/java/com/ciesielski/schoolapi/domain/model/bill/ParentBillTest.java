package com.ciesielski.schoolapi.domain.model.bill;

import com.ciesielski.schoolapi.domain.exceptions.bill.ParentBillException;
import com.ciesielski.schoolapi.domain.model.Child;
import com.ciesielski.schoolapi.domain.model.Parent;
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

class ParentBillTest {

    public static Stream<Arguments> provideFullCostCalculationsTest() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(10), BigDecimal.valueOf(20), BigDecimal.valueOf(30), BigDecimal.valueOf(30)),
                Arguments.of(BigDecimal.valueOf(12.5), BigDecimal.valueOf(15), BigDecimal.valueOf(7.5), BigDecimal.valueOf(27.5)),
                Arguments.of(BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(10), BigDecimal.valueOf(0))
        );
    }

    @ParameterizedTest
    @MethodSource("provideFullCostCalculationsTest")
    void fullCostCalculationsTest(final BigDecimal firstChildCost,
                                  final BigDecimal secondChildCost,
                                  final BigDecimal thirdChildCost,
                                  final BigDecimal fullCostA) throws ParentBillException {
        // GIVEN:
        final Parent parentA = new Parent(0L, "A", "A");
        final Parent parentB = new Parent(1L, "B", "B");

        List<ChildBill> childBills = List.of(
                mockChildBillWithChildAndCost(createChildWithParent(parentA), firstChildCost),
                mockChildBillWithChildAndCost(createChildWithParent(parentA), secondChildCost),
                mockChildBillWithChildAndCost(createChildWithParent(parentB), thirdChildCost)
        );

        // WHEN:
        List<ParentBill> parentBill = ParentBill.createParentBills(childBills);

        // THEN:
        ParentBill parentBillA = getParentBillForParent(parentA, parentBill);
        ParentBill parentBillB = getParentBillForParent(parentB, parentBill);

        Assertions.assertEquals(fullCostA, parentBillA.getParentCost());
        Assertions.assertEquals(thirdChildCost, parentBillB.getParentCost());
    }

    @Test
    void createEmptyParentBillTest() {
        // GIVEN:
        final Parent parent = new Parent(0L, "", "");

        // WHEN:
        final ParentBill parentBill = ParentBill.createEmptyParentBill(parent);

        // THEN:
        Assertions.assertEquals(parent, parentBill.getParent());
        Assertions.assertEquals(0, parentBill.getChildrenBills().size());
        Assertions.assertEquals(BigDecimal.ZERO, parentBill.getParentCost());
    }

    @Test
    void parentBillFromEmptyChildrenBillsTest() {
        // WHEN/THEN:
        Assertions.assertThrows(
                ParentBillException.class,
                () -> ParentBill.createParentBills(Collections.emptyList())
        );
    }

    private Child createChildWithParent(final Parent parent) {
        return new Child(0L, "", "", parent, null);
    }

    private ChildBill mockChildBillWithChildAndCost(final Child child, final BigDecimal childCost) {
        final ChildBill childBill = Mockito.mock(ChildBill.class);
        Mockito.when(childBill.getChild()).thenReturn(child);
        Mockito.when(childBill.getChildCost()).thenReturn(childCost);
        return childBill;
    }

    private ParentBill getParentBillForParent(Parent parentA, List<ParentBill> parentBill) throws ParentBillException {
        return parentBill.stream()
                .filter(pb -> pb.getParent().equals(parentA))
                .findFirst()
                .orElseThrow(ParentBillException::new);
    }
}