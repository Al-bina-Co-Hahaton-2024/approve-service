package ru.albina.approve.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;

@Data
public class DoctorWorkScheduleDto {

    @NotNull
    private UUID doctorId;

    @Min(1)
    private Double hours;

    private Set<DayOfWeek> workDays;

    private LocalTime startWorkDay;

}
