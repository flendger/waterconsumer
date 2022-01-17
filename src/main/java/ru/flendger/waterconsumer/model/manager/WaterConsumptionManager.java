package ru.flendger.waterconsumer.model.manager;

import ru.flendger.waterconsumer.model.dto.WaterConsumptionDto;

import java.time.LocalDate;

public interface WaterConsumptionManager {
    WaterConsumptionDto createNewConsumption(LocalDate date);

    void save(WaterConsumptionDto waterConsumptionDto);
}
