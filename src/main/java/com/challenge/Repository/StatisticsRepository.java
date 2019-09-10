package com.challenge.Repository;

import com.challenge.Model.Entities.Forecast;
import com.challenge.Model.Entities.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface StatisticsRepository extends JpaRepository<Statistic, Long> {
    Statistic findTopByOrderByIdDesc();
}
