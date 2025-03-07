package ru.albina.approve.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.albina.approve.domain.Modality;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;

@Data
public class DoctorChangeDto {
    @NotNull
    private UUID doctorId;
    private Double rate;
    private Modality modality;
    private Set<Modality> optionalModality;
    private LocalDate startContract;
    private LocalDate endContract;
    private Double hours;
    private Set<DayOfWeek> workDays;
    private LocalTime startWorkDay;
}
