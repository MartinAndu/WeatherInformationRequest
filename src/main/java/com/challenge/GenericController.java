package com.challenge;

import com.challenge.Model.Response.ForecastResponse;
import com.challenge.Services.interfaces.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@Controller
@RequestMapping(value = "/api/forecast")
public class GenericController {

    @Autowired
    private  ForecastService forecastService;

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
  	public String getWeather(@RequestParam Integer day) {
        return forecastService.getWeatherByDay(day).getWeather();
  	}

    @RequestMapping(value="/report/all", method = RequestMethod.GET)
    public ResponseEntity<List<ForecastResponse>>  getFullReport() {
        return new ResponseEntity<>(forecastService.getFullReport(), HttpStatus.OK);
    }


}
