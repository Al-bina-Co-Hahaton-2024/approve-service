package ru.albina.approve.service.sceduler;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.albina.approve.repository.DoctorScheduleRepository;

import java.util.UUID;
@Service
@RequiredArgsConstructor
public class MergedScheduleService {

    private final DoctorScheduleRepository doctorScheduleRepository;

    @Transactional(readOnly = true)
    public Page<UUID> getSchedules(Pageable pageable){
        return this.doctorScheduleRepository.getSchedulers(pageable);
    }
}
