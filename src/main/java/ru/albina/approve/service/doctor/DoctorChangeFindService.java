package ru.albina.approve.service.doctor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.albina.approve.dto.response.DoctorChangeResponse;
import ru.albina.approve.mapper.DoctorChangeMapper;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorChangeFindService {

    private final DoctorChangeService doctorChangeService;

    private final DoctorChangeMapper doctorChangeMapper;


    @Transactional(readOnly = true)
    public DoctorChangeResponse getByDoctorId(UUID doctorId) {
        return this.doctorChangeMapper.to(
                this.doctorChangeService.getByDoctorId(doctorId)
        );
    }


    @Transactional(readOnly = true)
    public Page<DoctorChangeResponse> getAll(Pageable pageable) {
        return this.doctorChangeService.getByAll(pageable).map(doctorChangeMapper::to);
    }
}
