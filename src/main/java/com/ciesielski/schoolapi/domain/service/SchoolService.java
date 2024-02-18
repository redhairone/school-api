package com.ciesielski.schoolapi.domain.service;

import com.ciesielski.schoolapi.domain.exceptions.NoSuchSchoolException;
import com.ciesielski.schoolapi.domain.model.Attendance;
import com.ciesielski.schoolapi.domain.model.Child;
import com.ciesielski.schoolapi.domain.model.School;
import com.ciesielski.schoolapi.domain.model.bill.SchoolBill;
import com.ciesielski.schoolapi.domain.repo.AttendanceRepo;
import com.ciesielski.schoolapi.domain.repo.ChildRepo;
import com.ciesielski.schoolapi.domain.repo.SchoolRepo;
import com.ciesielski.schoolapi.domain.util.LocalDateTimeUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepo schoolRepo;
    private final ChildRepo childRepo;
    private final AttendanceRepo attendanceRepo;

    @Transactional
    public SchoolBill getSchoolBillForMonth(final Long id, final int month) {
        // Find SCHOOL
        final School school = schoolRepo.findSchoolById(id)
                .orElseThrow(() -> new NoSuchSchoolException(id));

        // Find CHILDREN by school id
        final List<Child> children = childRepo.findAllChildrenBySchoolId(id);

        // Find ATTENDANCES by children ids and in month
        final List<Long> childrenIds = children.stream().map(Child::getId).toList();
        final List<Attendance> attendances = attendanceRepo.findAllAttendanceByChildIdInAndDateBetween(
                childrenIds,
                LocalDateTimeUtils.createStartOfChosenMonth(month),
                LocalDateTimeUtils.createStartOfChosenMonth(month + 1)
        );

        return SchoolBill.createSchoolBills(school, attendances);
    }
}
