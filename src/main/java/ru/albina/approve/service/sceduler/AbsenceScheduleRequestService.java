package ru.albina.approve.service.sceduler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.albina.approve.domain.AbsenceScheduleEntity;
import ru.albina.approve.dto.request.AbsenceScheduleDto;
import ru.albina.approve.mapper.AbsenceScheduleMapper;

@Service
@RequiredArgsConstructor
public class AbsenceScheduleRequestService {

    private final AbsenceScheduleService absenceScheduleService;

    private final AbsenceScheduleMapper absenceScheduleMapper;

    @Transactional
    public void create(AbsenceScheduleDto doctorChange) {
        final var request = this.absenceScheduleService.save(this.absenceScheduleMapper.from(doctorChange));
        this.validate(request);
    }

    private void validate(AbsenceScheduleEntity absenceScheduleEntity) {

        if (absenceScheduleEntity.getStart().isAfter(absenceScheduleEntity.getEnd())) {
            throw new IllegalArgumentException("Invalid start < end");
        }
    }
}
