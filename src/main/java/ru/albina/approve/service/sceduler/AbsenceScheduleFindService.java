package ru.albina.approve.service.sceduler;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.albina.approve.dto.response.AbsenceScheduleResponse;
import ru.albina.approve.mapper.AbsenceScheduleMapper;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AbsenceScheduleFindService {

    private final AbsenceScheduleService absenceScheduleService;

    private final AbsenceScheduleMapper absenceScheduleMapper;


    @Transactional(readOnly = true)
    public List<AbsenceScheduleResponse> getByDoctorId(UUID doctorId) {
        return this.absenceScheduleService.findAllByDoctorId(doctorId).stream().map(absenceScheduleMapper::to).toList();
    }


    @Transactional(readOnly = true)
    public Page<AbsenceScheduleResponse> getAll(Pageable pageable) {
        return this.absenceScheduleService.getByAll(pageable).map(absenceScheduleMapper::to);
    }
}
