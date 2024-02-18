package com.ciesielski.schoolapi.domain.service;

import com.ciesielski.schoolapi.domain.exceptions.NoSuchParentException;
import com.ciesielski.schoolapi.domain.model.*;
import com.ciesielski.schoolapi.domain.model.bill.ChildBill;
import com.ciesielski.schoolapi.domain.model.bill.ParentBill;
import com.ciesielski.schoolapi.domain.repo.AttendanceRepo;
import com.ciesielski.schoolapi.domain.repo.ChildRepo;
import com.ciesielski.schoolapi.domain.repo.ParentRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParentService {

    private final ParentRepo parentRepo;
    private final ChildRepo childRepo;
    private final AttendanceRepo attendanceRepo;

    @Transactional
    public ParentBill getParentBillForMonth(Long id, int month) {
        // Find PARENT
        Parent parent = parentRepo.findParentById(id)
                .orElseThrow(() -> new NoSuchParentException(id));

        // Find CHILDREN by parent id
        List<Child> children = childRepo.findAllChildrenByParentId(id);

        // Find ATTENDANCES by children ids and in month
        List<Long> childrenIds = children.stream().map(Child::getId).toList();
        List<Attendance> attendances = attendanceRepo.findAllAttendanceByChildIdInAndDateBetween(
                childrenIds,
                createStartOfChosenMonth(month),
                createStartOfChosenMonth(month + 1)
        );

        return ParentBill.createParentBill(parent, mapAttendanceIntoChildBill(attendances));
    }

    private List<ChildBill> mapAttendanceIntoChildBill(final List<Attendance> attendances) {
        return attendances.stream()
                .collect(Collectors.groupingBy(Attendance::getChild))
                .entrySet().stream()
                .map(mapEntry -> ChildBill.createChildBill(mapEntry.getKey(), mapEntry.getValue()))
                .toList();
    }

    private LocalDateTime createStartOfChosenMonth(int month) {
        return LocalDateTime.of(LocalDate.now().withMonth(month).withDayOfMonth(1), LocalTime.parse("00:00"));
    }
}
