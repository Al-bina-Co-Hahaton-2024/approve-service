package ru.albina.approve.controller.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.albina.approve.dto.request.DoctorChangeDto;
import ru.albina.approve.dto.response.DoctorChangeResponse;
import ru.albina.approve.service.doctor.DoctorChangeConfirmationService;
import ru.albina.approve.service.doctor.DoctorChangeFindService;
import ru.albina.approve.service.doctor.DoctorChangeRequestService;
import ru.albina.backlib.configuration.WebConstants;
import ru.albina.backlib.configuration.auto.OpenApiConfiguration;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(WebConstants.FULL_WEB + "/doctor-changes")
@RequiredArgsConstructor
public class DoctorChangesController {

    private final DoctorChangeRequestService doctorChangeRequestService;

    private final DoctorChangeFindService doctorChangeFindService;

    private final DoctorChangeConfirmationService doctorChangeConfirmationService;


    @Operation(
            summary = "Отправить изменения о враче на проверку или обновить такой запрос если уже был",
            security = @SecurityRequirement(name = OpenApiConfiguration.JWT),
            responses = {
                    @ApiResponse(
                            description = "ОК",
                            responseCode = "200"
                    )
            }
    )
    //TODO @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping
    public void updateRequestIfExists(
            @RequestBody DoctorChangeDto doctorChanges
    ) {
        this.doctorChangeRequestService.createOrUpdate(doctorChanges);
    }


    @Operation(
            summary = "Получить запрос на обновление данных врача",
            security = @SecurityRequirement(name = OpenApiConfiguration.JWT),
            responses = {
                    @ApiResponse(
                            description = "ОК",
                            responseCode = "200"
                    )
            }
    )
    //TODO @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/")
    public DoctorChangeResponse getByDoctor(
            @RequestParam("doctorId") UUID doctorId
    ) {
        return this.doctorChangeFindService.getByDoctorId(doctorId);
    }


    @Operation(
            summary = "Получить все запросы на обновление данных врача",
            security = @SecurityRequirement(name = OpenApiConfiguration.JWT),
            responses = {
                    @ApiResponse(
                            description = "ОК",
                            responseCode = "200"
                    )
            }
    )
    //TODO @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public Page<DoctorChangeResponse> pages(
            Pageable pageable
    ) {
        return this.doctorChangeFindService.getAll(pageable);
    }


    @Operation(
            summary = "Согласовать изменения в карточку сотрудника",
            security = @SecurityRequirement(name = OpenApiConfiguration.JWT),
            responses = {
                    @ApiResponse(
                            description = "ОК",
                            responseCode = "200"
                    )
            }
    )
    //TODO @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("{id}/approve")
    public void approve(
            @PathVariable("id") UUID requestId
    ) {
        this.doctorChangeConfirmationService.approve(requestId);
    }

    @Operation(
            summary = "Отклонить изменения в карточку сотрудника",
            security = @SecurityRequirement(name = OpenApiConfiguration.JWT),
            responses = {
                    @ApiResponse(
                            description = "ОК",
                            responseCode = "200"
                    )
            }
    )
    //TODO @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("{id}")
    public void disapprove(
            @PathVariable("id") UUID requestId
    ) {
        this.doctorChangeConfirmationService.disapprove(requestId);
    }

    @Operation(
            summary = "Найти заявки по ID",
            security = @SecurityRequirement(name = OpenApiConfiguration.JWT),
            responses = {
                    @ApiResponse(
                            description = "ОК",
                            responseCode = "200"
                    )
            }
    )
    //TODO @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/find-by-ids")
    public List<DoctorChangeResponse> getAllByIds(
            @RequestBody Set<UUID> ids
    ) {
        return this.doctorChangeFindService.getAllByIds(ids);
    }

}
