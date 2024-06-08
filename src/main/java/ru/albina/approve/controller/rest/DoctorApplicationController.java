package ru.albina.approve.controller.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.albina.approve.service.sceduler.MergedScheduleService;
import ru.albina.backlib.configuration.WebConstants;
import ru.albina.backlib.configuration.auto.OpenApiConfiguration;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(WebConstants.FULL_WEB + "/doctor-applications")
@RequiredArgsConstructor
public class DoctorApplicationController {

    private final MergedScheduleService mergedScheduleService;


    @Operation(
            summary = "Получить список запросов",
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
    public Page<UUID> createRequest(
            Pageable pageable
    ) {
        return this.mergedScheduleService.getSchedules(pageable);
    }

}
