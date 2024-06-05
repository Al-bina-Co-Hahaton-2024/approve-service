package ru.albina.approve.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "absence_schedule_request")
public class AbsenceScheduleRequestEntity {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @Column(name = "doctor_id", nullable = false)
    private UUID doctorId;

    @NotNull
    @Column(name = "start", nullable = false)
    private Instant start;

    @NotNull
    @Column(name = "\"end\"", nullable = false)
    private Instant end;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbsenceScheduleRequestEntity that = (AbsenceScheduleRequestEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}