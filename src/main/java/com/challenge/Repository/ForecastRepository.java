package com.challenge.Repository;

import com.challenge.Model.Entities.Forecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface ForecastRepository extends JpaRepository<Forecast, Long> {
    Forecast findByDay(int day);
}
