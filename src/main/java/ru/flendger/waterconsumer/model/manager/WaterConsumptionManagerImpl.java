package ru.flendger.waterconsumer.model.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.waterconsumer.model.dto.WaterConsumptionDto;
import ru.flendger.waterconsumer.model.entity.WaterConsumption;
import ru.flendger.waterconsumer.model.mapper.WaterConsumptionMapper;
import ru.flendger.waterconsumer.model.service.DateService;
import ru.flendger.waterconsumer.model.service.WaterConsumptionService;

import java.time.LocalDate;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class WaterConsumptionManagerImpl implements WaterConsumptionManager {
    private static final int defaultConsumption = 250;

    private final WaterConsumptionService waterConsumptionService;
    private final DateService dateService;
    private final WaterConsumptionMapper waterConsumptionMapper;

    @Override
    public WaterConsumptionDto createNewConsumption(LocalDate date) {
        LocalDate consumptionDate = Objects.requireNonNullElse(date, dateService.current());

        int overallConsumption = waterConsumptionService.getConsumptionByDate(consumptionDate);

        return WaterConsumptionDto
                .builder()
                .consumptionDate(consumptionDate)
                .quantity(defaultConsumption)
                .overallQuantity(overallConsumption)
                .build();
    }

    @Override
    public void save(WaterConsumptionDto waterConsumptionDto) {
        WaterConsumption waterConsumption = waterConsumptionMapper.from(waterConsumptionDto);

        waterConsumptionService.save(waterConsumption);
    }
}
