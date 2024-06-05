package ru.albina.approve.mapper;

import org.mapstruct.Mapper;
import ru.albina.approve.configuration.MapperConfiguration;
import ru.albina.approve.domain.DoctorChangeEntity;
import ru.albina.approve.dto.medical.DoctorUpdateRequest;

@Mapper(config = MapperConfiguration.class)
public interface MedicalMapper {

    DoctorUpdateRequest from(DoctorChangeEntity doctorChangeEntity);
}
