package ru.albina.approve.domain;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "doctor_change")
public class DoctorChangeEntity {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @Column(name = "doctor_id", nullable = false)
    private UUID doctorId;

    @Column(name = "rate")
    private Double rate;

    @Size(max = 30)
    @Column(name = "modality", length = 30)
    @Enumerated(EnumType.STRING)
    private Modality modality;

    @Type(
            value = ListArrayType.class,
            parameters = {
                    @Parameter(
                            name = ListArrayType.SQL_ARRAY_TYPE,
                            value = "varchar"
                    )
            }
    )
    @Column(name = "optional_modality", columnDefinition = "_varchar")
    private List<Modality> optionalModality;

    @Column(name = "start_contract")
    private LocalDate startContract;

    @Column(name = "end_contract")
    private LocalDate endContract;

    @Column(name = "hours")
    private Double hours;

    @Column(name = "work_days")
    private Integer workDays;

    @Column(name = "weekend_days")
    private Integer weekendDays;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorChangeEntity that = (DoctorChangeEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}