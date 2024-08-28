package Tower;

import Flyable.Coordinates;
import Flyable.Flyable;
import Flyable.NoTowerException;

import java.util.List;

public class WeatherTower extends Tower {

  public String getWeather(Coordinates p_coordinates) {

    return (WeatherProvider.getInstance().getCurrentWeather(p_coordinates));
  }

  void changeWeather() throws NoTowerException, UnregisteredException {

    List<Flyable> observers = this.getObservers();

    for (int i = 0; i < observers.size(); i++) {
      observers.get(i).updateConditions();
    }
  }
}
