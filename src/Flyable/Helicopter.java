package Flyable;

import Tower.UnregisteredException;

public class Helicopter extends Aircraft {

  public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
    super(p_id, p_name, p_coordinate);
  }

  @Override
  public void updateConditions()
      throws NoTowerException, UnregisteredException {

    if (this.weatherTower == null) {
      throw new NoTowerException("This aircraft is not registered to a tower "
                                 + "and cannot get weather info");
    }

    String weather = new String(this.weatherTower.getWeather(this.coordinates));

    switch (weather) {

    case "RAIN":
      this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
      if (this.current_weather != weather) {
        System.out.println(this.name + "(" + this.id +
                           ") : I love the sound of rain on the cockpit");
        this.current_weather = weather;
      }
      break;

    case "FOG":
      this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
      if (this.current_weather != weather) {
        System.out.println(this.name + "(" + this.id +
                           ") : Can't see anything, hope i don't crash");
        this.current_weather = weather;
      }
      break;

    case "SUN":
      this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
      this.coordinates.setHeight(this.coordinates.getHeight() + 2);
      if (this.current_weather != weather) {
        System.out.println(this.name + "(" + this.id +
                           ") : It's getting hot up there");
        this.current_weather = weather;
      }
      break;

    case "SNOW":
      this.coordinates.setHeight(this.coordinates.getHeight() - 12);
      if (this.coordinates.getHeight() == 0) {
        System.out.println(this.name + "(" + this.id +
                           ") : Landing at coordinates : " +
                           this.coordinates.getLongitude() + "/" +
                           this.coordinates.getLatitude());
        this.weatherTower.unregister(this);
        return;
      }
      if (this.current_weather != weather) {
        System.out.println(this.name + "(" + this.id +
                           ") : I hope the snow won't melt in the motor");
        this.current_weather = weather;
      }
      break;

    default:
      System.out.println("Pouet pouet pouet..");
    }
  }
}
