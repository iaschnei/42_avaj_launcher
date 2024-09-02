package Tower;

import Flyable.Coordinates;
import java.util.Random;

public class WeatherProvider {

  private static WeatherProvider INSTANCE;
  private String[] weather = new String[1];

  private WeatherProvider() {}

  // Ensure it is a Singleton
  public static WeatherProvider getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new WeatherProvider();
    }

    return (INSTANCE);
  }

  public String getCurrentWeather(Coordinates p_coordinate) {

    Random rand = new Random();

    int number = (p_coordinate.getHeight() + p_coordinate.getLatitude() +
                  p_coordinate.getLongitude() + rand.nextInt(4)) %
                 4;

    switch (number) {

    case 0:
      this.weather[0] = "RAIN";
      break;

    case 1:
      this.weather[0] = "FOG";
      break;

    case 2:
      this.weather[0] = "SUN";
      break;

    case 3:
      this.weather[0] = "SNOW";
      break;

    default:
      this.weather[0] = null;
    }

    return (this.weather[0]);
  }
}
