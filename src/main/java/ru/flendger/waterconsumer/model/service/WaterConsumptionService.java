package ru.flendger.waterconsumer.model.service;

import org.springframework.stereotype.Service;
import ru.flendger.waterconsumer.model.entity.WaterConsumption;

import java.time.LocalDate;
import java.util.List;

@Service
public interface WaterConsumptionService {
    List<WaterConsumption> findAll();

    int getConsumptionByDate(LocalDate date);

    void save(WaterConsumption waterConsuming);
}
