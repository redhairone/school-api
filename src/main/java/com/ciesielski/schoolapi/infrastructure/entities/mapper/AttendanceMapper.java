package com.ciesielski.schoolapi.infrastructure.entities.mapper;

import com.ciesielski.schoolapi.domain.model.Attendance;
import com.ciesielski.schoolapi.infrastructure.entities.AttendanceEntity;

public class AttendanceMapper {
    public static Attendance map(AttendanceEntity input) {
        return new Attendance(
                input.getId(),
                input.getEntryDate(),
                input.getExitDate(),
                ChildMapper.map(input.getChild())
        );
    }
}
