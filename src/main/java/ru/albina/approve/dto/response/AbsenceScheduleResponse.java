package ru.albina.approve.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AbsenceScheduleResponse {
    private UUID id;

    private UUID doctorId;

    private LocalDate start;
    
    private LocalDate end;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
