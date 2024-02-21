package com.ciesielski.schoolapi.domain.service;

import com.ciesielski.schoolapi.domain.exceptions.bill.ChildBillException;
import com.ciesielski.schoolapi.domain.exceptions.NoSuchParentException;
import com.ciesielski.schoolapi.domain.exceptions.bill.ParentBillException;
import com.ciesielski.schoolapi.domain.model.*;
import com.ciesielski.schoolapi.domain.model.bill.ChildBill;
import com.ciesielski.schoolapi.domain.model.bill.ParentBill;
import com.ciesielski.schoolapi.domain.repo.AttendanceRepo;
import com.ciesielski.schoolapi.domain.repo.ParentRepo;
import com.ciesielski.schoolapi.domain.util.LocalDateTimeUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentService {
    private final AttendanceRepo attendanceRepo;
    private final ParentRepo parentRepo;

    public ParentBill getParentBillForMonth(final Long parentId, final int month) {
        final List<Attendance> attendances = attendanceRepo.findAllChildAttendancesForParentInMonth(
                parentId,
                LocalDateTimeUtils.createStartOfChosenMonth(month),
                LocalDateTimeUtils.createStartOfChosenMonth(month + 1)
        );

        try {
            final List<ChildBill> childrenBills = ChildBill.createChildBills(attendances);
            return ParentBill.createParentBills(childrenBills).get(0);
        } catch (ChildBillException | ParentBillException e) {
            return getEmptyParentBill(parentId);
        }
    }

    private ParentBill getEmptyParentBill(final Long schoolId) {
        final Parent parent = parentRepo.findParentById(schoolId).orElseThrow(() -> new NoSuchParentException(schoolId));
        return ParentBill.createEmptyParentBill(parent);
    }
}
