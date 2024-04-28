package com.irctc.repository;

import com.irctc.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TrainRepository extends JpaRepository<Train, Long> {

    @Query("SELECT t.trainName FROM TrainStops ts1 JOIN TrainStops ts2 ON ts1.trainId = ts2.trainId JOIN Train t ON ts1.trainId = t.id JOIN Station s1 ON ts1.stationId = s1.id JOIN Station s2 ON ts2.stationId = s2.id WHERE s1.stationName = :fromLocation AND s2.stationName = :toLocation AND DATE(ts1.departureDate) = :departureDate AND ts2.stopOrder>ts1.stopOrder")
    List<String> findTrainsBetweenStations(@Param("fromLocation") String fromLocation,
                                          @Param("toLocation") String toLocation,
                                          @Param("departureDate") LocalDate departureDate);
}