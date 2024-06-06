package ru.albina.approve.dto.medical;

import lombok.Data;
import ru.albina.approve.domain.Modality;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class DoctorUpdateRequest {

    private Double rate;

    private Double hours;

    private Modality modality;

    private LocalDate startContract;

    private LocalDate endContract;

    private List<Modality> optionalModality;

    private Set<DayOfWeek> workDays;
}
