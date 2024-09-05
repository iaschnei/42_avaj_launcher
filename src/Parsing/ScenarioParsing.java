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
          "Error on aircraft line, incorrect format");
    }

    if (ret[0] != "Helicopter" && ret[0] != "Baloon" && ret[0] != "JetPlane") {
      throw new ScenarioFormatException(
          "Error on aircraft line, incorrect format");
    }

    String regex = "[0-9]+";

    if (ret[2].matches(regex) == false || ret[3].matches(regex) == false ||
        ret[4].matches(regex) == false) {

      throw new ScenarioFormatException(
          "Error on aircraft line, incorrect format");
    }
    
    if (atoi(ret[2]) > 100 || atoi(ret[3]) > 100 || atoi(ret[4]) > 100) {

      throw new ScenarioFormatException(
          "Error on aircraft line, coordinates are too big");
    }

    return (ret);
  }

  private static int atoi(String str) throws ScenarioFormatException {

    int result = 0;
    for (int i = 0; i < str.length(); i++) {
      char digit = (char)(str.charAt(i) - '0');
      result += (digit * Math.pow(10, (str.length() - i - 1)));
    }

    return (result);
  }
}
