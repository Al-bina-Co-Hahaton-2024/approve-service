package ru.albina.approve.controller.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.albina.approve.dto.request.DoctorWorkScheduleDto;
import ru.albina.approve.dto.response.DoctorWorkScheduleResponse;
import ru.albina.approve.service.sceduler.DoctorWorkScheduleConfirmationService;
import ru.albina.approve.service.sceduler.DoctorWorkScheduleFindService;
import ru.albina.approve.service.sceduler.DoctorWorkScheduleRequestService;
import ru.albina.backlib.configuration.WebConstants;
import ru.albina.backlib.configuration.auto.OpenApiConfiguration;
import ru.albina.backlib.model.security.LibPrincipal;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(WebConstants.FULL_WEB + "/doctor-work-schedulers")
@RequiredArgsConstructor
public class DoctorWorkScheduleController {

    private final DoctorWorkScheduleRequestService doctorWorkScheduleRequestService;

    private final DoctorWorkScheduleFindService doctorWorkScheduleFindService;

    private final DoctorWorkScheduleConfirmationService doctorWorkScheduleConfirmationService;


    @Operation(
            summary = "Отправить запрос на изменение рабочего графика",
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
    public void createRequest(
            @RequestBody DoctorWorkScheduleDto doctorWorkScheduleDto
    ) {
        this.doctorWorkScheduleRequestService.create(doctorWorkScheduleDto);
    }


    @Operation(
            summary = "Получить свои запросы на изменение рабочего графика",
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
    public List<DoctorWorkScheduleResponse> getByDoctor(
            LibPrincipal libPrincipal
    ) {
        return this.doctorWorkScheduleFindService.getByDoctorId(libPrincipal.getPrincipal().id());
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
        this.doctorWorkScheduleConfirmationService.approve(requestId);
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
        this.doctorWorkScheduleConfirmationService.disapprove(requestId);
    }

}
