package ru.albina.approve.service.doctor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.albina.approve.domain.DoctorChangeEntity;
import ru.albina.approve.exception.EntityNotFoundException;
import ru.albina.approve.repository.DoctorChangeRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorChangeService {

    private final DoctorChangeRepository doctorChangeRepository;

    @Transactional(readOnly = true)
    public Optional<DoctorChangeEntity> findByDoctorId(UUID doctorId) {
        return this.doctorChangeRepository.findByDoctorId(doctorId);
    }

    @Transactional(readOnly = true)
    public DoctorChangeEntity getByDoctorId(UUID doctorId) {
        return this.findByDoctorId(doctorId).orElseThrow(
                () -> new EntityNotFoundException("Can't find changes for a doctor " + doctorId)
        );
    }

    @Transactional(readOnly = true)
    public Page<DoctorChangeEntity> getByAll(Pageable pageable) {
        return this.doctorChangeRepository.findAll(pageable);
    }


    @Transactional
    public DoctorChangeEntity save(DoctorChangeEntity doctorChangeEntity) {
        return this.doctorChangeRepository.save(doctorChangeEntity);
    }

    @Transactional(readOnly = true)
    public DoctorChangeEntity getById(UUID id) {
        return this.doctorChangeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find changes by id " + id)
        );
    }

    @Transactional
    public void deleteById(UUID requestId) {
        this.doctorChangeRepository.deleteById(requestId);
    }

    @Transactional(readOnly = true)
    public List<DoctorChangeEntity> getAllByIds(Set<UUID> ids) {
        return this.doctorChangeRepository.findAllById(ids);
    }
}
