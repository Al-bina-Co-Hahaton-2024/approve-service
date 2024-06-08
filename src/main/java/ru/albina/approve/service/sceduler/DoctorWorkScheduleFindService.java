package ru.albina.approve.service.sceduler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.albina.approve.dto.response.DoctorWorkScheduleResponse;
import ru.albina.approve.mapper.DoctorWorkScheduleMapper;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorWorkScheduleFindService {

    private final DoctorWorkScheduleService doctorWorkScheduleService;

    private final DoctorWorkScheduleMapper doctorWorkScheduleMapper;


    @Transactional(readOnly = true)
    public List<DoctorWorkScheduleResponse> getByDoctorId(UUID doctorId) {
        return this.doctorWorkScheduleService.findAllByDoctorId(doctorId).stream().map(doctorWorkScheduleMapper::to).toList();
    }

    @Transactional(readOnly = true)
    public List<DoctorWorkScheduleResponse> getAllByIds(Set<UUID> ids) {
        return this.doctorWorkScheduleService.getAllByIds(ids).stream().map(doctorWorkScheduleMapper::to).toList();
    }
}
