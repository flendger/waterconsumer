package ru.flendger.waterconsumer.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class WaterConsumptionDto {
    private LocalDate consumptionDate;
    private int quantity;
    private int overallQuantity;
}
