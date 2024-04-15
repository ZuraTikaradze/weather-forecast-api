package ge.zura.weatherforecastapi.model;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record WeatherForecastModel(
        @NotNull(message = "Date cannot be null")
        LocalDate date,
        @Min(value = -20, message = "Temperature must be at least -20")
        @Max(value = 55, message = "Temperature must not exceed 55")
        int temperatureC,
        @NotBlank(message = "Summary cannot be empty")
        @Size(max = 200, message = "Summary cannot exceed 200 characters")
        String summary) {
    public int getTemperatureF() {
        return 32 + (int) (temperatureC / 0.5556);
    }
}
