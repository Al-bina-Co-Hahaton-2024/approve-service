package ru.albina.approve.dto.response;

import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;

@Data
public class DoctorWorkScheduleResponse {
    private UUID id;
    private UUID doctorId;

    private Double hours;

    private Set<DayOfWeek> workDays;

    private LocalTime startWorkDay;

}
