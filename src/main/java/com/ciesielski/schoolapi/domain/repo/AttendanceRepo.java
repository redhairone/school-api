package com.ciesielski.schoolapi.domain.repo;

import com.ciesielski.schoolapi.domain.model.Attendance;

import java.time.LocalDateTime;
import java.util.List;

public interface AttendanceRepo {
    List<Attendance> findAllChildAttendancesForParentInMonth(final Long parentId, final LocalDateTime startDate, final LocalDateTime endDate);
    List<Attendance> findAllChildAttendancesForSchoolInMonth(final Long schoolId, final LocalDateTime startDate, final LocalDateTime endDate);
}
