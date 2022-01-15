package ru.flendger.waterconsumer.model.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.waterconsumer.model.dto.WaterConsumptionDto;
import ru.flendger.waterconsumer.model.entity.WaterConsumption;
import ru.flendger.waterconsumer.model.mapper.WaterConsumptionMapper;
import ru.flendger.waterconsumer.model.service.DateService;
import ru.flendger.waterconsumer.model.service.WaterConsumptionService;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class WaterConsumptionManagerImpl implements WaterConsumptionManager {
    private static final int defaultConsumption = 250;

    private final WaterConsumptionService waterConsumptionService;
    private final DateService dateService;
    private final WaterConsumptionMapper waterConsumptionMapper;

    @Override
    public WaterConsumptionDto createNewConsumption() {
        LocalDate current = dateService.current();

        int overallConsumption = waterConsumptionService.getConsumptionByDate(current);

        return WaterConsumptionDto
                .builder()
                .consumptionDate(current)
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
