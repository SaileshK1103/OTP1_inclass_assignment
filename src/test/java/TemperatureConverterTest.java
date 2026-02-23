import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {
    TemperatureConverter converter = new TemperatureConverter();

    @org.junit.jupiter.api.Test
    void fahrenheitToCelsius() {
        // formula: (32°F − 32) × 5/9 = 0°C
        assertEquals(0.0, converter.fahrenheitToCelsius(32.0), 0.01);
        // formula: (212°F − 32) × 5/9 = 100°C
        assertEquals(100.0, converter.fahrenheitToCelsius(212.0), 0.01);
    }

    @org.junit.jupiter.api.Test
    void celsiusToFahrenheit() {
        // formula: (0°C × 9/5) + 32 = 32°F
        assertEquals(32.0, converter.celsiusToFahrenheit(0.0), 0.01);
        // formula: (100°C × 9/5) + 32 = 212°F
        assertEquals(212.0, converter.celsiusToFahrenheit(100.0), 0.01);
    }

    @org.junit.jupiter.api.Test
    void isExtremeTemperature() {
        // Test extreme cold
        assertTrue(converter.isExtremeTemperature(-40.1));
        // Test extreme heat
        assertTrue(converter.isExtremeTemperature(50.1));
        // Test normal temperature
        assertFalse(converter.isExtremeTemperature(25.0));
    }

    @org.junit.jupiter.api.Test
    void kelvinToCelsius() {
        assertEquals(26.85, converter.kelvinToCelsius(300.0), 0.01);
        assertEquals(-273.15, converter.kelvinToCelsius(0.0), 0.01);
    }
}