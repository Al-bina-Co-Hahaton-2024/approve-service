package ru.albina.approve.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import ru.albina.approve.dto.medical.AbsenceSchedulerUpdateRequest;
import ru.albina.approve.dto.medical.DoctorUpdateRequest;
import ru.albina.backlib.configuration.WebConstants;

import java.util.Optional;
import java.util.UUID;

@Component
public class MedicalClient {

    private final WebClient webClient;

    public MedicalClient(WebClient.Builder libWebClientBuilder) {
        this.webClient = libWebClientBuilder
                .baseUrl(Optional.ofNullable(System.getenv("MEDICAL_SERVICE_HOST")).orElse("http://localhost:8081"))
                .build();
    }


    public void updateDoctor(UUID doctorId, DoctorUpdateRequest doctorUpdateRequest) {
        this.webClient.patch()
                .uri(uriBuilder -> uriBuilder.path(WebConstants.FULL_PRIVATE + "/doctors/{id}").build(doctorId))
                .bodyValue(doctorUpdateRequest)
                .retrieve()
                .toBodilessEntity()
                .block();
    }


    public void addAbsenceScheduler(UUID doctorId, AbsenceSchedulerUpdateRequest absenceSchedulerUpdateRequest) {
        this.webClient.patch()
                .uri(uriBuilder -> uriBuilder.path(WebConstants.FULL_PRIVATE + "/doctors/{id}/absence-schedulers").build(doctorId))
                .bodyValue(absenceSchedulerUpdateRequest)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}
