package com.ciesielski.schoolapi.infrastructure.jpa.repo;

import com.ciesielski.schoolapi.domain.model.Child;
import com.ciesielski.schoolapi.domain.repo.ChildRepo;
import com.ciesielski.schoolapi.infrastructure.entities.ChildEntity;
import com.ciesielski.schoolapi.infrastructure.entities.mapper.ChildMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface ChildJpaRepo extends JpaRepository<ChildEntity, Long>, ChildRepo {

    default List<Child> findAllChildrenByParentId(Long id) {
        final ChildMapper childMapper = new ChildMapper();

        return this.findAllByParentId(id).stream()
                .map(childMapper::map)
                .collect(Collectors.toList());
    }

    List<ChildEntity> findAllByParentId(Long id);


}
