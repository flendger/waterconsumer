package ru.flendger.waterconsumer.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.flendger.waterconsumer.model.dto.WaterConsumptionDto;
import ru.flendger.waterconsumer.model.manager.WaterConsumptionManager;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/water")
@RequiredArgsConstructor
public class WaterConsumptionController {
    private final WaterConsumptionManager waterConsumptionManager;

    @GetMapping
    public ResponseEntity<?> get(@RequestParam(value = "date", required = false)
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                             LocalDate date) {
        WaterConsumptionDto newConsumption = waterConsumptionManager.createNewConsumption(date);

        return ResponseEntity.ok(newConsumption);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody WaterConsumptionDto waterConsumptionDto) {
        waterConsumptionManager.save(waterConsumptionDto);

        return ResponseEntity.ok().build();
    }
}
