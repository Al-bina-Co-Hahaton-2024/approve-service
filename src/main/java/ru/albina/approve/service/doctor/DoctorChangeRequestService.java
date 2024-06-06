package ru.albina.approve.service.doctor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.albina.approve.domain.DoctorChangeEntity;
import ru.albina.approve.dto.request.DoctorChangeDto;
import ru.albina.approve.mapper.DoctorChangeMapper;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorChangeRequestService {

    private final DoctorChangeService doctorChangeService;

    private final DoctorChangeMapper doctorChangeMapper;

    @Transactional
    public void createOrUpdate(DoctorChangeDto doctorChange) {
        final var request = this.doctorChangeService.findByDoctorId(doctorChange.getDoctorId())
                .map(entity -> this.doctorChangeMapper.update(entity, doctorChange))
                .orElseGet(() -> this.doctorChangeService.save(this.doctorChangeMapper.from(doctorChange)));
        this.validate(request);
    }

    private void validate(DoctorChangeEntity doctorChangeEntity) {
        if (
                Optional.ofNullable(doctorChangeEntity.getStartContract()).orElse(LocalDate.MIN)
                        .isAfter(
                                Optional.ofNullable(doctorChangeEntity.getEndContract()).orElse(LocalDate.MAX)
                        )
        ) {
            throw new IllegalArgumentException("Invalid contract date time");
        }
    }
}
