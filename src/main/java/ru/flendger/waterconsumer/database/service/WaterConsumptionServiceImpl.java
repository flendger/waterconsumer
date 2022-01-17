package ru.flendger.waterconsumer.database.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.waterconsumer.database.repository.WaterConsumptionRepository;
import ru.flendger.waterconsumer.model.entity.WaterConsumption;
import ru.flendger.waterconsumer.model.service.WaterConsumptionService;

import java.time.LocalDate;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class WaterConsumptionServiceImpl implements WaterConsumptionService {
    private final WaterConsumptionRepository waterConsumptionRepository;

    @Override
    public int getConsumptionByDate(LocalDate date) {
        return Objects.requireNonNullElse(waterConsumptionRepository.overallQuantityByDate(date), 0);
    }

    @Override
    public void save(WaterConsumption waterConsuming) {
        waterConsumptionRepository.save(waterConsuming);
    }
}
