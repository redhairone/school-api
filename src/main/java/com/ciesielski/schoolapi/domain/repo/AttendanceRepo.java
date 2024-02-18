package com.ciesielski.schoolapi.domain.repo;

import com.ciesielski.schoolapi.domain.model.Attendance;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public interface AttendanceRepo {
    List<Attendance> findAllAttendanceByChildIdInAndDateBetween(final Collection<Long> ids, final LocalDateTime start, final LocalDateTime end);
}
