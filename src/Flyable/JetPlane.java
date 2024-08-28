package Flyable;

import Tower.UnregisteredException;

public class JetPlane extends Aircraft {

  public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
    super(p_id, p_name, p_coordinate);
  }

  @Override
  public void updateConditions()
      throws NoTowerException, UnregisteredException {

    if (this.weatherTower == null) {
      throw new NoTowerException("This aircraft is not registered to a tower " +
          "and cannot get weather info");
    }

    String weather = this.weatherTower.getWeather(this.coordinates);

    switch (weather) {

      case "RAIN":
        this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
        if (this.current_weather != weather) {
          System.out.println(this.name + "(" + this.id + ") : Rain");
          this.current_weather = weather;
        }
        break;

      case "FOG":
        this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
        if (this.current_weather != weather) {
          System.out.println(this.name + "(" + this.id + ") : Fog");
          this.current_weather = weather;
        }
        break;

      case "SUN":
        this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
        this.coordinates.setHeight(this.coordinates.getHeight() + 2);
        if (this.current_weather != weather) {
          System.out.println(this.name + "(" + this.id + ") : Sun");
          this.current_weather = weather;
        }
        break;

      case "SNOW":
        this.coordinates.setHeight(this.coordinates.getHeight() - 7);
        if (this.coordinates.getHeight() == 0) {
          this.weatherTower.unregister(this);
          return;
        }
        if (this.current_weather != weather) {
          System.out.println(this.name + "(" + this.id + ") : Snow");
          this.current_weather = weather;
        }
        break;
    }
  }
}
