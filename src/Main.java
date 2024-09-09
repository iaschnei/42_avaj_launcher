import Flyable.AircraftFactory;
import Parsing.FileToString;
import Parsing.ScenarioParsing;
import Tower.WeatherTower;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) throws Exception {

    try {

      if (args.length != 1) {
        System.out.println("Please input a scenario .txt file");
        return;
      }

      String scenarioStr = FileToString.ReadFileToString(args[0]);
      ArrayList<String> scenario = FileToString.StringToList(scenarioStr);

      int scenarioSize = ScenarioParsing.getSimulationSize(scenario);

      WeatherTower tower = new WeatherTower();
      AircraftFactory factory = AircraftFactory.getInstance();

      for (int i = 1; i < scenario.size(); i++) {

        String[] aircraftData = ScenarioParsing.splitAircraftData(scenario.get(i));

        tower.register(
            factory.newAircraft(aircraftData[0], aircraftData[1],
                ScenarioParsing.atoi(aircraftData[2]),
                ScenarioParsing.atoi(aircraftData[3]),
                ScenarioParsing.atoi(aircraftData[4])));
      }

      System.out.println(scenarioSize);

      for (int j = 0; j < scenarioSize; j++) {

        tower.changeWeather();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

/*
 * try {
 *
 * if (args.length != 2) {
 * System.out.println("Please input a scenario .txt file");
 * }
 *
 * WeatherTower tower = new WeatherTower();
 * AircraftFactory factory = AircraftFactory.getInstance();
 *
 * Helicopter helico = (Helicopter)factory.newAircraft(
 * "Helicopter", "HelicoRigolo", 70, 70, 70);
 *
 * tower.register(helico);
 *
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 * tower.changeWeather();
 *
 * } catch (Exception e) {
 * System.out.println(e);
 * }
 *
 */
