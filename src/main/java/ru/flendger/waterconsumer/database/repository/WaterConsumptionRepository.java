package ru.flendger.waterconsumer.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.flendger.waterconsumer.model.entity.WaterConsumption;

import java.time.LocalDate;
import java.util.Optional;

public interface WaterConsumptionRepository extends JpaRepository<WaterConsumption, Long> {

    @Query("select sum(quantity) from WaterConsumption where consumptionDate = :cons_date")
    Integer overallQuantityByDate(@Param("cons_date") LocalDate date);

    Optional<WaterConsumption> findFirstByConsumptionDateOrderByUpdatedAtDesc(LocalDate consumptionDate);
}
