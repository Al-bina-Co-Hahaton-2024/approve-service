package ru.albina.approve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.albina.approve.domain.DoctorWorkScheduleEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface DoctorWorkScheduleRepository extends JpaRepository<DoctorWorkScheduleEntity, UUID> {

    List<DoctorWorkScheduleEntity> findAllByDoctorId(UUID doctorId);
}
