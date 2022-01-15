package ru.flendger.waterconsumer.database.service;

import org.springframework.stereotype.Service;
import ru.flendger.waterconsumer.model.entity.WaterConsumption;
import ru.flendger.waterconsumer.model.service.WaterConsumptionService;

import java.time.LocalDate;

@Service
public class WaterConsumptionServiceImpl implements WaterConsumptionService {
    @Override
    public int getConsumptionByDate(LocalDate date) {
        return 0;
    }

    @Override
    public void save(WaterConsumption waterConsuming) {

    }
}
