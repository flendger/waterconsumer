package ru.flendger.waterconsumer.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.flendger.waterconsumer.model.entity.WaterConsumption;

import java.time.LocalDate;

public interface WaterConsumptionRepository extends JpaRepository<WaterConsumption, Long> {
    @Query("select sum(quantity) from WaterConsumption where consumptionDate = :cons_date")
    int overallQuantityByDate(@Param("cons_date") LocalDate date);
}
