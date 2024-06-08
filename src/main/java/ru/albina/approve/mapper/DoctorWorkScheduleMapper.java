package ru.albina.approve.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.albina.approve.configuration.MapperConfiguration;
import ru.albina.approve.domain.DoctorWorkScheduleEntity;
import ru.albina.approve.dto.request.DoctorWorkScheduleDto;
import ru.albina.approve.dto.response.DoctorWorkScheduleResponse;

import java.util.UUID;

@Mapper(config = MapperConfiguration.class, imports = UUID.class)
public interface DoctorWorkScheduleMapper {


    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    DoctorWorkScheduleEntity from(DoctorWorkScheduleDto doctorWorkScheduleDto);


    DoctorWorkScheduleResponse to(DoctorWorkScheduleEntity doctorWorkScheduleEntity);
}
