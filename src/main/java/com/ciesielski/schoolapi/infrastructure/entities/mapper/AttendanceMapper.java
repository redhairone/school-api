package com.ciesielski.schoolapi.infrastructure.entities.mapper;

import com.ciesielski.schoolapi.domain.model.Attendance;
import com.ciesielski.schoolapi.infrastructure.entities.AttendanceEntity;

public class AttendanceMapper implements Mapper<AttendanceEntity, Attendance>{
    @Override
    public Attendance map(AttendanceEntity input) {
        return Attendance.builder()
                .id(input.getId())
                .entry_date(input.getEntry_date())
                .exit_date(input.getExit_date())
                .child_id(input.getChild_id())
                .build();
    }
}
