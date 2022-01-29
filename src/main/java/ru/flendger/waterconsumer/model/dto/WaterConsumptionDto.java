package ru.flendger.waterconsumer.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
public class WaterConsumptionDto {
    private LocalDate consumptionDate;
    private int quantity;
    private int overallQuantity;
    private LocalTime lastUpdate;
}
