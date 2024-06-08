package ru.albina.approve.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.albina.approve.domain.DoctorWorkScheduleEntity;

import java.util.UUID;

@Repository
public interface DoctorScheduleRepository extends JpaRepository<DoctorWorkScheduleEntity, UUID> {


    @Query(value =
            """
                 SELECT id FROM (
                        select id from doctor_work_schedule
                        union all
                        select id from absence_schedule
                    ) as dwsiasi
                order by id
            """,
            countQuery = """
                    SELECT count(id) FROM (
                        select id from doctor_work_schedule
                        union all
                        select id from absence_schedule
                    ) as dwsiasi
                """,
            nativeQuery = true)
    Page<UUID> getSchedulers(Pageable pageable);
}
