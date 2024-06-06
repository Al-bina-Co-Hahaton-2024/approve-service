package ru.albina.approve.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class AbsenceScheduleDto {
    @NotNull
    private UUID doctorId;

    @NotNull
    private LocalDate start;

    @NotNull
    private LocalDate end;
}
