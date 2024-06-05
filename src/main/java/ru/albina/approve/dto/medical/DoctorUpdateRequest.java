package ru.albina.approve.dto.medical;

import lombok.Data;
import ru.albina.approve.domain.Modality;

import java.time.LocalDate;
import java.util.List;

@Data
public class DoctorUpdateRequest {

    private Double rate;

    private Integer workDays;

    private Integer weekendDays;


    private Double hours;

    private Modality modality;

    private LocalDate startContract;

    private LocalDate endContract;

    private List<Modality> optionalModality;
}
