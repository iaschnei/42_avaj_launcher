package Flyable;

import Tower.UnregisteredException;
import Tower.WeatherTower;

public abstract class Flyable {

  protected WeatherTower weatherTower;

  public abstract void updateConditions() throws NoTowerException, UnregisteredException;

  public void registerTower(WeatherTower p_tower) {
    this.weatherTower = p_tower;
  }
}
