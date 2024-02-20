package com.ciesielski.schoolapi.presentation.dto.mapper;

import com.ciesielski.schoolapi.domain.model.Child;
import com.ciesielski.schoolapi.presentation.dto.ChildDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ChildDtoMapperTest {

    @Test
    void shouldMapCorrectlyTest() {
        //GIVEN:
        final Child child = new Child(1L, "", "", null, null);

        //WHEN:
        final ChildDto childDto = ChildDtoMapper.map(child);

        //THEN:
        Assertions.assertNotNull(childDto);
        Assertions.assertEquals(child.getId(), childDto.getId());
        Assertions.assertEquals(child.getFirstname(), childDto.getFirstname());
        Assertions.assertEquals(child.getLastname(), childDto.getLastname());
    }

}