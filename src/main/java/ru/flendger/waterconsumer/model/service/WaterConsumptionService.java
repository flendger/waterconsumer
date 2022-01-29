package ru.flendger.waterconsumer.model.service;

import org.springframework.stereotype.Service;
import ru.flendger.waterconsumer.model.entity.WaterConsumption;

import java.time.LocalDate;
import java.util.Optional;

@Service
public interface WaterConsumptionService {
    int getConsumptionByDate(LocalDate date);

    void save(WaterConsumption waterConsuming);

    Optional<WaterConsumption> getLastByDate(LocalDate consumptionDate);
}
