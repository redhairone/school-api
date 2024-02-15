package com.ciesielski.schoolapi.infrastructure.entities.mapper;

public interface Mapper<IN, OUT> {

    OUT map(IN input);
}
