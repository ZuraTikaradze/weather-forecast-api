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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AddWeatherForecastTests {

    @Autowired
    private WeatherForecastService weatherForecastService;

    @MockBean
    private WeatherForecastRepository repository;

    @Test
    public void addsWeatherForecastCorrectly() {

        WeatherForecast forecast = new WeatherForecast(1, 20, LocalDate.now(), "Sunny");
        when(repository.save(any(WeatherForecast.class))).thenReturn(forecast);
        WeatherForecastModel weatherForecastRequestDto = new WeatherForecastModel(LocalDate.now(), 20, "Sunny");
        WeatherForecastModel savedForecast = weatherForecastService.addWeatherForecast(weatherForecastRequestDto);

        assertNotNull(savedForecast);
        assertEquals("Sunny", savedForecast.summary());
        assertEquals(20, savedForecast.temperatureC());
    }
}
