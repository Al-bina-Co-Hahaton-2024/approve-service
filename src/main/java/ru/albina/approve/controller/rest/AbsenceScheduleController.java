package ru.albina.approve.controller.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.albina.approve.dto.request.AbsenceScheduleDto;
import ru.albina.approve.dto.response.AbsenceScheduleResponse;
import ru.albina.approve.service.sceduler.AbsenceScheduleConfirmationService;
import ru.albina.approve.service.sceduler.AbsenceScheduleFindService;
import ru.albina.approve.service.sceduler.AbsenceScheduleRequestService;
import ru.albina.backlib.configuration.WebConstants;
import ru.albina.backlib.configuration.auto.OpenApiConfiguration;
import ru.albina.backlib.model.security.LibPrincipal;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(WebConstants.FULL_WEB + "/absence-schedulers")
@RequiredArgsConstructor
public class AbsenceScheduleController {

    private final AbsenceScheduleRequestService absenceScheduleRequestService;

    private final AbsenceScheduleFindService absenceScheduleFindService;

    private final AbsenceScheduleConfirmationService absenceScheduleConfirmationService;


    @Operation(
            summary = "Запросить отгул",
            security = @SecurityRequirement(name = OpenApiConfiguration.JWT),
            responses = {
                    @ApiResponse(
                            description = "ОК",
                            responseCode = "200"
                    )
            }
    )
    //TODO @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public void create(
            @RequestBody AbsenceScheduleDto absenceScheduleDto
    ) {
        this.absenceScheduleRequestService.create(absenceScheduleDto);
    }


    @Operation(
            summary = "Получить свои запросы на отгулы",
            security = @SecurityRequirement(name = OpenApiConfiguration.JWT),
            responses = {
                    @ApiResponse(
                            description = "ОК",
                            responseCode = "200"
                    )
            }
    )
    //TODO @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/mine")
    public List<AbsenceScheduleResponse> getByDoctor(
            LibPrincipal libPrincipal
    ) {
        return this.absenceScheduleFindService.getByDoctorId(libPrincipal.getPrincipal().id());
    }


    @Operation(
            summary = "Получить все запросы на отгулы врачей",
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
    public Page<AbsenceScheduleResponse> pages(
            Pageable pageable
    ) {
        return this.absenceScheduleFindService.getAll(pageable);
    }


    @Operation(
            summary = "Согласовать отгул",
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
        this.absenceScheduleConfirmationService.approve(requestId);
    }

    @Operation(
            summary = "Отклонить отгул",
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
        this.absenceScheduleConfirmationService.disapprove(requestId);
    }

}
