import Flyable.AircraftFactory;
import Flyable.Helicopter;
import Flyable.NoTowerException;
import Flyable.UnknownFlyableException;
import Tower.UnregisteredException;
import Tower.WeatherTower;

public class Main {

  public static void main(String[] args)
      throws UnknownFlyableException, NoTowerException, UnregisteredException {

    try {
      WeatherTower tower = new WeatherTower();
      AircraftFactory factory = AircraftFactory.getInstance();

      Helicopter helico = (Helicopter)factory.newAircraft(
          "Helicopter", "HelicoRigolo", 70, 70, 70);

      tower.register(helico);

      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();
      tower.changeWeather();

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
