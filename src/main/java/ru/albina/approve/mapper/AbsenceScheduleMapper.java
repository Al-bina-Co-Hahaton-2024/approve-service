package ru.albina.approve.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.albina.approve.configuration.MapperConfiguration;
import ru.albina.approve.domain.AbsenceScheduleEntity;
import ru.albina.approve.dto.request.AbsenceScheduleDto;
import ru.albina.approve.dto.response.AbsenceScheduleResponse;

import java.util.UUID;

@Mapper(config = MapperConfiguration.class, imports = UUID.class)
public interface AbsenceScheduleMapper {

    @Mapping(target = "id", ignore = true)
    AbsenceScheduleEntity update(@MappingTarget AbsenceScheduleEntity entity, AbsenceScheduleDto absenceScheduleDto);

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    AbsenceScheduleEntity from(AbsenceScheduleDto absenceScheduleDto);


    AbsenceScheduleResponse to(AbsenceScheduleEntity entity);
}
