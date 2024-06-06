package ru.albina.approve.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class AbsenceScheduleDto {
    @NotNull
    private UUID doctorId;

    @NotNull
    private Instant start;

    @NotNull
    private Instant end;
}
