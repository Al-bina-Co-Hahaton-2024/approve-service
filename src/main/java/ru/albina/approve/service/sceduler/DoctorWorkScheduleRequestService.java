package ru.albina.approve.service.sceduler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.albina.approve.domain.DoctorWorkScheduleEntity;
import ru.albina.approve.dto.request.DoctorWorkScheduleDto;
import ru.albina.approve.mapper.DoctorWorkScheduleMapper;

@Service
@RequiredArgsConstructor
public class DoctorWorkScheduleRequestService {

    private final DoctorWorkScheduleService doctorWorkScheduleService;

    private final DoctorWorkScheduleMapper doctorWorkScheduleMapper;

    @Transactional
    public void create(DoctorWorkScheduleDto doctorWorkScheduleDto) {
        final var request = this.doctorWorkScheduleService.save(this.doctorWorkScheduleMapper.from(doctorWorkScheduleDto));
        this.validate(request);
    }

    private void validate(DoctorWorkScheduleEntity absenceScheduleEntity) {

        if (absenceScheduleEntity.getHours() <= 0) {
            throw new IllegalArgumentException("Invalidрщ");
        }
    }
}
