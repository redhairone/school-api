package com.ciesielski.schoolapi.infrastructure.jpa.repo;

import com.ciesielski.schoolapi.domain.model.Attendance;
import com.ciesielski.schoolapi.domain.repo.AttendanceRepo;
import com.ciesielski.schoolapi.infrastructure.entities.AttendanceEntity;
import com.ciesielski.schoolapi.infrastructure.entities.mapper.AttendanceMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AttendanceJpaRepo extends JpaRepository<AttendanceEntity, Long>, AttendanceRepo {
    default List<Attendance> findAllChildAttendancesForParentInMonth(final Long parentId, final LocalDateTime startDate, final LocalDateTime endDate) {
        return this.fetchAllByParentIdAndEntryDateBetween(parentId, startDate, endDate).stream()
                .map(AttendanceMapper::map).toList();
    }

    default List<Attendance> findAllChildAttendancesForSchoolInMonth(final Long schoolId, final LocalDateTime startDate, final LocalDateTime endDate) {
        return this.fetchAllBySchoolIdAndEntryDateBetween(schoolId, startDate, endDate).stream()
                .map(AttendanceMapper::map).toList();
    }

    @Query(value = "SELECT a FROM attendance a " +
            "JOIN FETCH a.child ch " +
            "JOIN FETCH ch.parent p " +
            "JOIN FETCH ch.school sch " +
            "WHERE p.id = ?1 AND a.entryDate >= ?2 AND a.exitDate < ?3")
    List<AttendanceEntity> fetchAllByParentIdAndEntryDateBetween(final Long parentId, final LocalDateTime start, final LocalDateTime end);

    @Query(value = "SELECT a FROM attendance a " +
            "JOIN FETCH a.child ch " +
            "JOIN FETCH ch.parent p " +
            "JOIN FETCH ch.school sch " +
            "WHERE sch.id = ?1 AND a.entryDate >= ?2 AND a.exitDate < ?3")
    List<AttendanceEntity> fetchAllBySchoolIdAndEntryDateBetween(final Long schoolId, final LocalDateTime start, final LocalDateTime end);
}
