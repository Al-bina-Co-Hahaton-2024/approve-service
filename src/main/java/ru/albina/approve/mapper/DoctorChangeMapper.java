package ru.albina.approve.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.albina.approve.configuration.MapperConfiguration;
import ru.albina.approve.domain.DoctorChangeEntity;
import ru.albina.approve.dto.request.DoctorChangeDto;
import ru.albina.approve.dto.response.DoctorChangeResponse;

import java.util.UUID;

@Mapper(config = MapperConfiguration.class, imports = UUID.class)
public interface DoctorChangeMapper {

    @Mapping(target = "id", ignore = true)
    DoctorChangeEntity update(@MappingTarget DoctorChangeEntity entity, DoctorChangeDto doctorChange);

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    DoctorChangeEntity from(DoctorChangeDto doctorChange);


    DoctorChangeResponse to(DoctorChangeEntity entity);
}
