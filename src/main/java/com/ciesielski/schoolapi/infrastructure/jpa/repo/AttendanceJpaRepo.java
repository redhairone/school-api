package com.ciesielski.schoolapi.infrastructure.jpa.repo;

import com.ciesielski.schoolapi.domain.repo.AttendanceRepo;
import com.ciesielski.schoolapi.infrastructure.entities.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceJpaRepo extends JpaRepository<AttendanceEntity, Long>, AttendanceRepo {

}
