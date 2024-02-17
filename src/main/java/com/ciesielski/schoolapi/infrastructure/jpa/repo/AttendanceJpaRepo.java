package com.ciesielski.schoolapi.infrastructure.jpa.repo;

import com.ciesielski.schoolapi.domain.model.Attendance;
import com.ciesielski.schoolapi.domain.repo.AttendanceRepo;
import com.ciesielski.schoolapi.infrastructure.entities.AttendanceEntity;
import com.ciesielski.schoolapi.infrastructure.entities.mapper.AttendanceMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AttendanceJpaRepo extends JpaRepository<AttendanceEntity, Long>, AttendanceRepo {

    default List<Attendance> findAllAttendanceByChildIdIn(Collection<Long> ids) {
        return this.findAllByChildIdIn(ids).stream()
                .map(AttendanceMapper::map).toList();
    }

    List<AttendanceEntity> findAllByChildIdIn(Collection<Long> ids);
}
