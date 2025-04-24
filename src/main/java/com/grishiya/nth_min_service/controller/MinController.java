package com.grishiya.nth_min_service.controller;

import com.grishiya.nth_min_service.dto.NthMinResponse;
import com.grishiya.nth_min_service.service.NumberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Path;

@Tag(name = "nth minimum API")
@RestController
@RequestMapping("/api")
public class MinController {

    private final NumberService service;

    public MinController(NumberService service) {
        this.service = service;
    }
    @Operation(summary = "Вернуть N-й минимум из Excel-файла")
    @Parameters({
            @Parameter(name = "path", description = "Абсолютный путь к .xlsx"),
            @Parameter(name = "n",    description = "Порядковый номер (1-based)")
    })
    @GetMapping("/nth-min")
    public ResponseEntity<NthMinResponse> nthMin(
            @RequestParam String path,
            @RequestParam Integer n) throws IOException {
        int value = service.findNthMin(Path.of(path), n);
        return ResponseEntity.ok(new NthMinResponse(value));
    }
}
