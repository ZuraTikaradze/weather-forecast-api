package ge.zura.weatherforecastapi.controller;

import ge.zura.weatherforecastapi.model.WeatherForecastModel;
import ge.zura.weatherforecastapi.service.WeatherForecastService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/weather-forecast")
public class WeatherForecastController {

    private final WeatherForecastService weatherForecastService;

    @GetMapping
    public ResponseEntity<List<WeatherForecastModel>> getWeatherForecast() {
        return ResponseEntity.ok(weatherForecastService.getWeatherForecast());
    }

    @PostMapping
    public ResponseEntity<?> addWeatherForecast(@Valid @RequestBody WeatherForecastModel weatherForecastModel) {
        return ResponseEntity.ok(weatherForecastService.addWeatherForecast(weatherForecastModel));
    }
}
