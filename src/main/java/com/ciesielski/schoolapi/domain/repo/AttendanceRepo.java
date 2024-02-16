package com.ciesielski.schoolapi.domain.repo;

import com.ciesielski.schoolapi.domain.model.Attendance;

import java.util.Collection;
import java.util.List;

public interface AttendanceRepo {
    List<Attendance> findAllAttendanceByChildIdIn(Collection<Long> ids);
}
