package com.ciesielski.schoolapi.domain.service;

import com.ciesielski.schoolapi.domain.model.*;
import com.ciesielski.schoolapi.domain.repo.AttendanceRepo;
import com.ciesielski.schoolapi.domain.repo.ChildRepo;
import com.ciesielski.schoolapi.domain.repo.ParentRepo;
import com.ciesielski.schoolapi.infrastructure.entities.ChildEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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
        Parent parent = parentRepo.findParentById(id).orElseThrow();

        // Find CHILDREN by parent id
        List<Child> children = childRepo.findAllChildrenByParentId(id);

        // Find ATTENDANCES by children ids
        // todo: WIP
        List<Long> childrenIds = children.stream().map(Child::getId).toList();
//        Map<ChildEntity, List<Attendance>> attendances = attendanceRepo.findAllAttendanceByChildIdIn(childrenIds)
//                .stream().collect(Collectors.groupingBy(Attendance::getChildId));



        return ParentBill.builder()
                .parent(parent)
                .build();
    }
}
