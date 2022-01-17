package ru.flendger.waterconsumer.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.flendger.waterconsumer.model.dto.WaterConsumptionDto;
import ru.flendger.waterconsumer.model.manager.WaterConsumptionManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/water")
@RequiredArgsConstructor
public class WaterConsumptionController {
    private final WaterConsumptionManager waterConsumptionManager;

    @GetMapping
    public ResponseEntity<?> get(@RequestParam(value = "date", required = false) LocalDate date) {
        WaterConsumptionDto newConsumption = waterConsumptionManager.createNewConsumption(date);

        return ResponseEntity
                .ok(newConsumption);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody WaterConsumptionDto waterConsumptionDto) {
        waterConsumptionManager.save(waterConsumptionDto);

        return ResponseEntity
                .ok()
                .build();
    }
}
