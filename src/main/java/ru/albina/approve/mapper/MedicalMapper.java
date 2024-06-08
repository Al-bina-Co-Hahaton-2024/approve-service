package ru.albina.approve.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.albina.approve.configuration.MapperConfiguration;
import ru.albina.approve.domain.AbsenceScheduleEntity;
import ru.albina.approve.domain.DoctorChangeEntity;
import ru.albina.approve.domain.DoctorWorkScheduleEntity;
import ru.albina.approve.dto.medical.AbsenceSchedulerUpdateRequest;
import ru.albina.approve.dto.medical.DoctorUpdateRequest;

@Mapper(config = MapperConfiguration.class)
public interface MedicalMapper {


    DoctorUpdateRequest from(DoctorChangeEntity doctorChangeEntity);


    @Mapping(target = "startContract", ignore = true)
    @Mapping(target = "rate", ignore = true)
    @Mapping(target = "optionalModality", ignore = true)
    @Mapping(target = "modality", ignore = true)
    @Mapping(target = "endContract", ignore = true)
    DoctorUpdateRequest from(DoctorWorkScheduleEntity doctorWorkScheduleEntity);


    AbsenceSchedulerUpdateRequest from(AbsenceScheduleEntity absenceScheduleEntity);
}
