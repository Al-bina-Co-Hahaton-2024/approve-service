package ru.albina.approve.dto.medical;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AbsenceSchedulerUpdateRequest {

    private LocalDate start;

    private LocalDate end;
}
