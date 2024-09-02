package Tower;

import Flyable.Coordinates;
import Flyable.NoTowerException;

public class WeatherTower extends Tower {

  public String getWeather(Coordinates p_coordinates) {

    return (WeatherProvider.getInstance().getCurrentWeather(p_coordinates));
  }

  public void changeWeather() throws NoTowerException, UnregisteredException {

    this.conditionChanged();
  }
}
