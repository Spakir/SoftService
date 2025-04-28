package com.example.testing.softservice.controller;

import com.example.testing.softservice.model.RequestData;
import com.example.testing.softservice.service.SoftService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/soft/api")
@Tag(name = "Soft Controller API", description = "API Для работы с XML файлами")
public class SoftController {

    private final SoftService softService;

    @Autowired
    public SoftController(SoftService softService) {
        this.softService = softService;
    }

    @GetMapping("/min")
    @Operation(
            summary = "Поиск N-го минимального числа",
            description = "Находит N-ое минимальное число из указанного файла Excel."
    )
    @ApiResponse(responseCode = "200", description = "Успешный запрос",
            content = @Content(mediaType = "application.json", schema = @Schema(implementation = Long.class)))
    @ApiResponse(responseCode = "400", description = "Некорректные параметры или файл не найден",
            content = @Content(mediaType = "application.json", schema = @Schema(implementation = Exception.class)))
    public Long findMinByN(@Parameter(description = "DTO, содержащее путь к файлу и число N")
                           @RequestBody RequestData requestBody) {
        return softService.findMinimumElement(requestBody);
    }
}
