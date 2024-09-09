package Parsing;

import java.util.ArrayList;

public class ScenarioParsing {

  public static int getSimulationSize(ArrayList<String> content)
      throws ScenarioFormatException {

    if (content.size() < 2) {
      throw new ScenarioFormatException(
          "Not enough data in the scenario, please check subject's example");
    }

    if (content.get(0).matches("[0-9]+") == false) {

      throw new ScenarioFormatException(
          "Error on first line, expecting numbers only");
    }

    return (atoi(content.get(0)));
  }

  public static String[] splitAircraftData(String str)
      throws ScenarioFormatException {

    String[] ret = str.split(" ");

    if (ret.length != 5) {
      throw new ScenarioFormatException(
          "Error on aircraft line, missing informations, expected format is "
              + ": AircraftType Name Longitude Latitude Height");
    }

    if (!ret[0].equals("Helicopter") && !ret[0].equals("Baloon") &&
        !ret[0].equals("JetPlane")) {
      throw new ScenarioFormatException(
          "Error on aircraft line, unknown AircraftType");
    }

    String regex = "[0-9]+";

    if (ret[2].matches(regex) == false || ret[3].matches(regex) == false ||
        ret[4].matches(regex) == false) {

      throw new ScenarioFormatException(
          "Error on aircraft line, coordinates must be numbers only");
    }

    if (atoi(ret[4]) > 100) {

      ret[4] = "100";
    }
    if (atoi(ret[4]) == 0) {

      throw new ScenarioFormatException(
          "Error on aircraft line, aircraft can't register from the ground " +
              "(height is 0)");
    }

    return (ret);
  }

  public static int atoi(String str) throws ScenarioFormatException {

    int result = 0;
    for (int i = 0; i < str.length(); i++) {
      char digit = (char) (str.charAt(i) - '0');
      result += (digit * Math.pow(10, (str.length() - i - 1)));
    }

    return (result);
  }
}
