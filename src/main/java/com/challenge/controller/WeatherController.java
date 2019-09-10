package com.challenge.controller;

import com.challenge.exceptions.Messages;
import com.challenge.exceptions.types.DayNumberException;
import com.challenge.exceptions.types.InvalidNumberFormatException;
import com.challenge.model.response.StatisticResponse;
import com.challenge.services.interfaces.ForecastService;
import com.challenge.services.interfaces.StatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping(value = "/api/forecast")
public class WeatherController {

    public final Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);


    @Autowired
    private ForecastService forecastService;

    @Autowired
    private StatisticsService statisticsService;

  	// Aggregate root
  	@RequestMapping("/")
    public String home() {
        return "Welcome to forecast system application";
    }

    /**
     * Finds predicted weather on a day
     *
     * @param day provided day within 10 years.
     * @return predicted weather
     */
    @GetMapping(produces = "application/json")
  	public ResponseEntity getWeather(@RequestParam Integer day) {
        try {
            LOGGER.info("Getting weather by day {}", day);
            return ResponseEntity.ok(forecastService.getWeatherByDay(day));
        } catch (DayNumberException e) {
            LOGGER.error("Getting weather wasn't possible because : {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (InvalidNumberFormatException e) {
            LOGGER.error("The request parameter is not a valid integer number : {}", e.getMessage());
            return ResponseEntity.badRequest().body(Messages.NUMBER_FORMAT_EXCEPTION);
        }
  	}

    /**
     * Gets full forecast within 10 years
     * @return predicted weather
     */
    @RequestMapping(value="/report/all", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity  getFullReport() {
        LOGGER.info("Getting full report within 10 years");
        return ResponseEntity.ok(forecastService.getFullReport());
    }

    /**
     * Get data from the forecast.
     * @return predicted statistics
     */
    @RequestMapping(value="/report/statistics", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<StatisticResponse>  getStatisticsReport() {
        LOGGER.info("Getting statistics within 10 years");
        return ResponseEntity.ok(statisticsService.getStatistics());
    }


}
