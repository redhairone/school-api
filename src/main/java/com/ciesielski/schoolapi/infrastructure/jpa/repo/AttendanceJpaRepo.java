package com.ciesielski.schoolapi.infrastructure.jpa.repo;

import com.ciesielski.schoolapi.domain.model.Attendance;
import com.ciesielski.schoolapi.domain.repo.AttendanceRepo;
import com.ciesielski.schoolapi.infrastructure.entities.AttendanceEntity;
import com.ciesielski.schoolapi.infrastructure.entities.mapper.AttendanceMapper;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface AttendanceJpaRepo extends JpaRepository<AttendanceEntity, Long>, AttendanceRepo {

    default List<Attendance> findAllAttendanceByChildIdInAndDateBetween(final Collection<Long> ids, final LocalDateTime start, final LocalDateTime end) {
        return this.findAllByChildIdInAndEntryDateBetween(ids, start, end).stream()
                .map(AttendanceMapper::map).toList();
    }

    List<AttendanceEntity> findAllByChildIdInAndEntryDateBetween(final Collection<Long> ids, final LocalDateTime start, final LocalDateTime end);
}
