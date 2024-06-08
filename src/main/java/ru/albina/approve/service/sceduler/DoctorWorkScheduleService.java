package ru.albina.approve.service.sceduler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.albina.approve.domain.DoctorWorkScheduleEntity;
import ru.albina.approve.exception.EntityNotFoundException;
import ru.albina.approve.repository.DoctorWorkScheduleRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorWorkScheduleService {

    private final DoctorWorkScheduleRepository doctorWorkScheduleRepository;


    @Transactional(readOnly = true)
    public DoctorWorkScheduleEntity getById(UUID id) {
        return this.doctorWorkScheduleRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find doc changes by id " + id)
        );
    }

    @Transactional
    public DoctorWorkScheduleEntity save(DoctorWorkScheduleEntity doctorWorkScheduleEntity) {
        return this.doctorWorkScheduleRepository.save(doctorWorkScheduleEntity);
    }

    @Transactional
    public void deleteById(UUID requestId) {
        this.doctorWorkScheduleRepository.deleteById(requestId);
    }

    @Transactional(readOnly = true)
    public List<DoctorWorkScheduleEntity> findAllByDoctorId(UUID doctorId) {
       return this.doctorWorkScheduleRepository.findAllByDoctorId(doctorId);
    }
}
