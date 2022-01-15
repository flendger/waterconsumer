package ru.flendger.waterconsumer.model.service;

import org.springframework.stereotype.Service;
import ru.flendger.waterconsumer.model.entity.WaterConsumption;

import java.time.LocalDate;

@Service
public interface WaterConsumptionService {
    int getConsumptionByDate(LocalDate date);

    void save(WaterConsumption waterConsuming);
}
