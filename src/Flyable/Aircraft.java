package Flyable;

import Tower.UnregisteredException;

public class Aircraft extends Flyable {

  protected long id;
  protected String name;
  protected Coordinates coordinates;
  protected String current_weather;

  protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
    this.id = p_id;
    this.name = p_name;
    this.coordinates = p_coordinates;
  }

  @Override
  public void updateConditions() throws NoTowerException, UnregisteredException {
    throw new UnsupportedOperationException(
        "Unimplemented method 'updateConditions'");
  }
}
