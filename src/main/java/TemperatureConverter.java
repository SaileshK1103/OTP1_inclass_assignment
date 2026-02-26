import java.util.Scanner;

public class TemperatureConverter {
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public boolean isExtremeTemperature(double celsius) {
        return celsius < -40 || celsius > 50;
    }

    public double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TemperatureConverter converter = new TemperatureConverter();

        System.out.println("--- Full Temperature Converter Test ---");

        // 1. Test Celsius to Fahrenheit & Extreme check
        System.out.print("Enter Celsius: ");
        double c = scanner.nextDouble();
        System.out.println(c + "°C = " + converter.celsiusToFahrenheit(c) + "°F");
        System.out.println("Is Extreme? " + converter.isExtremeTemperature(c));

        // 2. Test Fahrenheit to Celsius
        System.out.print("\nEnter Fahrenheit: ");
        double f = scanner.nextDouble();
        System.out.println(f + "°F = " + converter.fahrenheitToCelsius(f) + "°C");

        // 3. Test Kelvin to Celsius
        System.out.print("\nEnter Kelvin: ");
        double k = scanner.nextDouble();
        System.out.println(k + "K = " + converter.kelvinToCelsius(k) + "°C");

        scanner.close();
    }
}
