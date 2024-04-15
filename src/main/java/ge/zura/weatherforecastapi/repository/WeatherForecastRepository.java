package ge.zura.weatherforecastapi.repository;

import ge.zura.weatherforecastapi.entity.WeatherForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherForecastRepository extends JpaRepository<WeatherForecast, Integer> {
}
