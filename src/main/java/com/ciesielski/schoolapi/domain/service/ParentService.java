package com.ciesielski.schoolapi.domain.service;

import com.ciesielski.schoolapi.domain.model.*;
import com.ciesielski.schoolapi.domain.repo.AttendanceRepo;
import com.ciesielski.schoolapi.domain.repo.ChildRepo;
import com.ciesielski.schoolapi.domain.repo.ParentRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParentService {

    private final ParentRepo parentRepo;
    private final ChildRepo childRepo;
    private final AttendanceRepo attendanceRepo;

    @Transactional
    public ParentBill getParentBillForMonth(Long id, int month) { //todo: add the month requirement
        // Find PARENT
        Parent parent = parentRepo.findParentById(id).orElseThrow();

        // Find CHILDREN by parent id
        List<Child> children = childRepo.findAllChildrenByParentId(id);

        // Find ATTENDANCES by children ids
        List<Long> childrenIds = children.stream().map(Child::getId).toList();
        List<ChildBill> attendances = attendanceRepo.findAllAttendanceByChildIdIn(childrenIds).stream()
                .collect(Collectors.groupingBy(Attendance::getChild))
                .entrySet().stream()
                .map(mapEntry -> new ChildBill(mapEntry.getKey(), mapEntry.getValue()))
                .toList();

        return new ParentBill(parent, attendances);
    }
}
