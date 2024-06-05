package ru.albina.approve.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.albina.approve.domain.DoctorChangeEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DoctorChangeRepository extends JpaRepository<DoctorChangeEntity, UUID> {

    Optional<DoctorChangeEntity> findByDoctorId(UUID doctorId);
}
