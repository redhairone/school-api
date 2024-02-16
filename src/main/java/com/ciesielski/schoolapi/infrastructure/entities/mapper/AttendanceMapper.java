package com.ciesielski.schoolapi.infrastructure.entities.mapper;

import com.ciesielski.schoolapi.domain.model.Attendance;
import com.ciesielski.schoolapi.infrastructure.entities.AttendanceEntity;

public class AttendanceMapper implements Mapper<AttendanceEntity, Attendance>{
    @Override
    public Attendance map(AttendanceEntity input) {
        ChildMapper childMapper = new ChildMapper();

        return new Attendance(
                input.getId(),
                input.getEntryDate(),
                input.getExitDate(),
                childMapper.map(input.getChild())
        );
    }
}
