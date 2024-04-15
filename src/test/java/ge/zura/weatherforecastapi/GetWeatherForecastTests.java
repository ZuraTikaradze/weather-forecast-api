package ge.zura.weatherforecastapi;

import ge.zura.weatherforecastapi.model.WeatherForecastModel;
import ge.zura.weatherforecastapi.entity.WeatherForecast;
import ge.zura.weatherforecastapi.repository.WeatherForecastRepository;
import ge.zura.weatherforecastapi.service.WeatherForecastService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GetWeatherForecastTests {

    @Autowired
    private WeatherForecastService weatherForecastService;

    @MockBean
    private WeatherForecastRepository weatherForecastRepository;

    @Test
    public void returnsCorrectForecasts() {

        WeatherForecast expectedForecast = new WeatherForecast(1, 25, LocalDate.now(), "Sunny");
        when(weatherForecastRepository.findAll()).thenReturn(Collections.singletonList(expectedForecast));

        List<WeatherForecastModel> result = weatherForecastService.getWeatherForecast();

        assertEquals(1, result.size(), "Should return exactly one forecast");
        WeatherForecastModel forecast = result.get(0);
        assertEquals("Sunny", forecast.summary(), "Summary should match");
        assertEquals(25, forecast.temperatureC(), "Temperature should match");
    }
}
