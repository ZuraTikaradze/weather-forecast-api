package ge.zura.weatherforecastapi.service;

import ge.zura.weatherforecastapi.model.WeatherForecastModel;

import java.util.List;

public interface WeatherForecastService {
    List<WeatherForecastModel> getWeatherForecast();

    WeatherForecastModel addWeatherForecast(WeatherForecastModel weatherForecastModel);

}
