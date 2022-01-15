package ru.flendger.waterconsumer.model.mapper;

import org.springframework.stereotype.Component;
import ru.flendger.waterconsumer.model.dto.WaterConsumptionDto;
import ru.flendger.waterconsumer.model.entity.WaterConsumption;

@Component
public class WaterConsumptionMapper {
    public WaterConsumption from(WaterConsumptionDto waterConsumptionDto) {
        return WaterConsumption
                .builder()
                .consumptionDate(waterConsumptionDto.getConsumptionDate())
                .quantity(waterConsumptionDto.getQuantity())
                .build();
    }
}
