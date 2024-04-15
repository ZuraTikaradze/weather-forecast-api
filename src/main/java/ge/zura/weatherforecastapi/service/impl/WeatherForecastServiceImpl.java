package ge.zura.weatherforecastapi.service.impl;

import ge.zura.weatherforecastapi.entity.WeatherForecast;
import ge.zura.weatherforecastapi.model.WeatherForecastModel;
import ge.zura.weatherforecastapi.repository.WeatherForecastRepository;
import ge.zura.weatherforecastapi.service.WeatherForecastService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherForecastServiceImpl implements WeatherForecastService {

    private final WeatherForecastRepository weatherForecastRepository;

    @Override
    public List<WeatherForecastModel> getWeatherForecast() {
        return weatherForecastRepository.findAll().stream()
                .map(entity -> new WeatherForecastModel(entity.getDate(), entity.getTemperatureC(), entity.getSummary()))
                .toList();
    }

    @Override
    public WeatherForecastModel addWeatherForecast(WeatherForecastModel weatherForecastModel) {
        WeatherForecast weatherForecast = new WeatherForecast(
                null,
                weatherForecastModel.temperatureC(),
                weatherForecastModel.date(),
                weatherForecastModel.summary()
        );
        weatherForecastRepository.save(weatherForecast);
        return weatherForecastModel;
    }
}
