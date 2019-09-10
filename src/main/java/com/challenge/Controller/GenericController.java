package com.challenge.Controller;

import com.challenge.Model.Entities.Forecast;
import com.challenge.Model.Response.ForecastResponse;
import com.challenge.Model.Response.StatisticResponse;
import com.challenge.Services.interfaces.ForecastService;
import com.challenge.Services.interfaces.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping(value = "/api/forecast")
public class GenericController {

    @Autowired
    private ForecastService forecastService;

    @Autowired
    private StatisticsService statisticsService;

  	// Aggregate root
  	@RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }

    /**
     * Finds predicted weather on a day
     *
     * @param day provided day within 10 years.
     * @return predicted weather
     */
    @GetMapping
  	public Forecast getWeather(@RequestParam Integer day) {
        return forecastService.getWeatherByDay(day);
  	}

    /**
     * Gets full forecast within 10 years
     * @return predicted weather
     */
    @RequestMapping(value="/report/all", method = RequestMethod.GET)
    public ResponseEntity<List<ForecastResponse>>  getFullReport() {
        return new ResponseEntity<>(forecastService.getFullReport(), HttpStatus.OK);
    }

    /**
     * Get data from the forecast.
     * @return predicted statistics
     */
    @RequestMapping(value="/report/statistics", method = RequestMethod.GET)
    public ResponseEntity<StatisticResponse>  getStatisticsReport() {
        return new ResponseEntity(statisticsService.getStatistics(), HttpStatus.OK);
    }


}
