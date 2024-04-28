package com.irctc.repository;

import com.irctc.entity.Train;
import com.irctc.entity.TrainStops;
import com.irctc.payload.SearchResultDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TrainStopsRepository extends JpaRepository<TrainStops, Long> {




}