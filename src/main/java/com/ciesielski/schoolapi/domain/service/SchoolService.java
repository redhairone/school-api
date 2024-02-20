package com.ciesielski.schoolapi.domain.service;

import com.ciesielski.schoolapi.domain.exceptions.bill.ChildBillException;
import com.ciesielski.schoolapi.domain.exceptions.NoSuchSchoolException;
import com.ciesielski.schoolapi.domain.exceptions.bill.ParentBillException;
import com.ciesielski.schoolapi.domain.exceptions.bill.SchoolBillException;
import com.ciesielski.schoolapi.domain.model.Attendance;
import com.ciesielski.schoolapi.domain.model.School;
import com.ciesielski.schoolapi.domain.model.bill.ChildBill;
import com.ciesielski.schoolapi.domain.model.bill.ParentBill;
import com.ciesielski.schoolapi.domain.model.bill.SchoolBill;
import com.ciesielski.schoolapi.domain.repo.AttendanceRepo;
import com.ciesielski.schoolapi.domain.repo.SchoolRepo;
import com.ciesielski.schoolapi.domain.util.LocalDateTimeUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final AttendanceRepo attendanceRepo;
    private final SchoolRepo schoolRepo;

    public SchoolBill getSchoolBillForMonth(final Long schoolId, final int month) {
        List<Attendance> attendances = attendanceRepo.findAllChildAttendancesForSchoolInMonth(
                schoolId,
                LocalDateTimeUtils.createStartOfChosenMonth(month),
                LocalDateTimeUtils.createStartOfChosenMonth(month + 1)
        );

        try {
            final List<ChildBill> childrenBills = ChildBill.createChildBills(attendances);
            final List<ParentBill> parentBills = ParentBill.createParentBills(childrenBills);
            return SchoolBill.createSchoolBill(parentBills);
        } catch (final ChildBillException | ParentBillException | SchoolBillException e) {
            return getEmptySchoolBill(schoolId);
        }
    }

    private SchoolBill getEmptySchoolBill(final Long schoolId) {
        final School school = schoolRepo.findSchoolById(schoolId).orElseThrow(() -> new NoSuchSchoolException(schoolId));
        return SchoolBill.createEmptySchoolBill(school);
    }
}
