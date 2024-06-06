package ru.albina.approve.service.sceduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.albina.approve.client.MedicalClient;
import ru.albina.approve.mapper.MedicalMapper;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AbsenceScheduleConfirmationService {

    private final AbsenceScheduleService absenceScheduleService;

    private final MedicalMapper medicalMapper;

    private final MedicalClient medicalClient;

    @Transactional
    public void approve(UUID requestId) {
        final var request = this.absenceScheduleService.getById(requestId);
        this.medicalClient.addAbsenceScheduler(request.getDoctorId(), this.medicalMapper.from(request));
        this.absenceScheduleService.deleteById(requestId);
    }

    @Transactional
    public void disapprove(UUID requestId) {
        this.absenceScheduleService.deleteById(requestId);
    }
}
