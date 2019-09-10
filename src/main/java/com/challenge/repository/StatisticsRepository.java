package com.challenge.repository;

import com.challenge.model.entities.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface StatisticsRepository extends JpaRepository<Statistic, Long> {
    Statistic findTopByOrderByIdDesc();
}
