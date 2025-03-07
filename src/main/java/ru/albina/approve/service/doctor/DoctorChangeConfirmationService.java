package ru.albina.approve.service.doctor;

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
public class DoctorChangeConfirmationService {

    private final DoctorChangeService doctorChangeService;

    private final MedicalMapper medicalMapper;

    private final MedicalClient medicalClient;

    @Transactional
    public void approve(UUID requestId) {
        final var request = this.doctorChangeService.getById(requestId);
        this.medicalClient.updateDoctor(request.getDoctorId(), this.medicalMapper.from(request));
        this.doctorChangeService.deleteById(requestId);
    }

    @Transactional
    public void disapprove(UUID requestId) {
        this.doctorChangeService.deleteById(requestId);
    }
}
