package ge.zura.weatherforecastapi;

import ge.zura.weatherforecastapi.controller.WeatherForecastController;
import ge.zura.weatherforecastapi.service.WeatherForecastService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WeatherForecastController.class)
public class AddWeatherForecastValidationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherForecastService weatherForecastService;

    @BeforeEach
    public void setup(WebApplicationContext webApplicationContext) {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void whenPostRequestToWeatherForecasts_AndValidWeatherForecast_thenCorrectResponse() throws Exception {
        String weatherForecastJson = "{\"date\":\"2023-10-01\",\"temperatureC\":25,\"summary\":\"Sunny\"}";

        mockMvc.perform(post("/weather-forecast")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(weatherForecastJson))
                .andExpect(status().isOk());
    }

    @Test
    public void whenPostRequestToWeatherForecasts_AndInvalidTemperature_thenBadRequest() throws Exception {
        String weatherForecastJson = "{\"date\":\"2023-10-01\",\"temperatureC\":60,\"summary\":\"Extremely hot\"}";

        mockMvc.perform(post("/weather-forecast")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(weatherForecastJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenPostRequestToWeatherForecasts_AndNullDate_thenBadRequest() throws Exception {
        String weatherForecastJson = "{\"temperatureC\":25,\"summary\":\"Sunny\"}";

        mockMvc.perform(post("/weather-forecast")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(weatherForecastJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenPostRequestToWeatherForecasts_AndEmptySummary_thenBadRequest() throws Exception {
        String weatherForecastJson = "{\"date\":\"2023-10-01\",\"temperatureC\":25,\"summary\":\"\"}";

        mockMvc.perform(post("/weather-forecast")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(weatherForecastJson))
                .andExpect(status().isBadRequest());
    }
}
