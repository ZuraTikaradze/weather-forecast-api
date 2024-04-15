CREATE TABLE IF NOT EXISTS weather_forecast (
                                                id INT AUTO_INCREMENT PRIMARY KEY,
                                                temperatureC INT,
                                                date DATE,
                                                summary VARCHAR(255),
    CONSTRAINT chk_temperature CHECK (temperatureC BETWEEN -20 AND 55) -- Optional: Add constraint based on your Java validation annotations
    );
