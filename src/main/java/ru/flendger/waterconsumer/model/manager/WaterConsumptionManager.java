package ru.flendger.waterconsumer.model.manager;

import ru.flendger.waterconsumer.model.dto.WaterConsumptionDto;

public interface WaterConsumptionManager {
    WaterConsumptionDto createNewConsumption();

    void save(WaterConsumptionDto waterConsumptionDto);
}
