import Flyable.AircraftFactory;
import Flyable.Helicopter;
import Tower.WeatherTower;

public class Main {

  public static void main(String[] args)
      throws Exception {

    try {

      if (args.length != 2) {
        System.out.println("Please input a scenario .txt file");
      }

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
