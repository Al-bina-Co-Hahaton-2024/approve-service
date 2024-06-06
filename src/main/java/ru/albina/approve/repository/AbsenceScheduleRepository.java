package ru.albina.approve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.albina.approve.domain.AbsenceScheduleEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface AbsenceScheduleRepository extends JpaRepository<AbsenceScheduleEntity, UUID> {

    List<AbsenceScheduleEntity> findAllByDoctorId(UUID doctorId);
}
