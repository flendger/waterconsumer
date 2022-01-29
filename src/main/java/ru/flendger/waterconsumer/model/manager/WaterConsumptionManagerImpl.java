package ru.flendger.waterconsumer.model.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.flendger.waterconsumer.model.dto.WaterConsumptionDto;
import ru.flendger.waterconsumer.model.entity.WaterConsumption;
import ru.flendger.waterconsumer.model.mapper.WaterConsumptionMapper;
import ru.flendger.waterconsumer.model.service.DateService;
import ru.flendger.waterconsumer.model.service.WaterConsumptionService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Optional;

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

        LocalTime lastUpdate = getLastUpdateTime(consumptionDate);

        return WaterConsumptionDto
                .builder()
                .consumptionDate(consumptionDate)
                .quantity(defaultConsumption)
                .overallQuantity(overallConsumption)
                .lastUpdate(lastUpdate)
                .build();
    }

    private LocalTime getLastUpdateTime(LocalDate consumptionDate) {
        Optional<WaterConsumption> waterConsumptionOptional = waterConsumptionService.getLastByDate(consumptionDate);
        if (waterConsumptionOptional.isEmpty()) {
            return LocalTime.of(0, 0);
        }

        WaterConsumption waterConsumption = waterConsumptionOptional.get();
        return LocalTime.from( waterConsumption.getUpdatedAt());
    }

    @Override
    public void save(WaterConsumptionDto waterConsumptionDto) {
        WaterConsumption waterConsumption = waterConsumptionMapper.from(waterConsumptionDto);

        waterConsumptionService.save(waterConsumption);
    }
}
