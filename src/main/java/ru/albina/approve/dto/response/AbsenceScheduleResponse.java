package ru.albina.approve.dto.response;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class AbsenceScheduleResponse {
    private UUID id;

    private UUID doctorId;

    private Instant start;
    
    private Instant end;
}
