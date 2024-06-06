package ru.albina.approve.dto.medical;

import lombok.Data;

import java.time.Instant;

@Data
public class AbsenceSchedulerUpdateRequest {

    private Instant start;

    private Instant end;
}
