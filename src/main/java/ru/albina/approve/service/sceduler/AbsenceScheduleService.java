package ru.albina.approve.service.sceduler;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.albina.approve.domain.AbsenceScheduleEntity;
import ru.albina.approve.exception.EntityNotFoundException;
import ru.albina.approve.repository.AbsenceScheduleRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AbsenceScheduleService {

    private final AbsenceScheduleRepository absenceScheduleRepository;

    @Transactional(readOnly = true)
    public List<AbsenceScheduleEntity> findAllByDoctorId(UUID doctorId) {
        return this.absenceScheduleRepository.findAllByDoctorId(doctorId);
    }


    @Transactional(readOnly = true)
    public Page<AbsenceScheduleEntity> getByAll(Pageable pageable) {
        return this.absenceScheduleRepository.findAll(pageable);
    }


    @Transactional
    public AbsenceScheduleEntity save(AbsenceScheduleEntity doctorChangeEntity) {
        return this.absenceScheduleRepository.save(doctorChangeEntity);
    }

    @Transactional(readOnly = true)
    public AbsenceScheduleEntity getById(UUID id) {
        return this.absenceScheduleRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find changes by id " + id)
        );
    }

    @Transactional
    public void deleteById(UUID requestId) {
        this.absenceScheduleRepository.deleteById(requestId);
    }
}
