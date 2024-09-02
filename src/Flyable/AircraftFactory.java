package Flyable;

public final class AircraftFactory {

  private static AircraftFactory INSTANCE;
  private long aircraft_id = 0;

  private AircraftFactory() {}

  // Ensure it is a Singleton
  public static AircraftFactory getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new AircraftFactory();
    }

    return (INSTANCE);
  }

  public Flyable newAircraft(String p_type, String p_name, int lon, int lat,
                             int hei) throws UnknownFlyableException {

    Coordinates p_coordinates = new Coordinates(lon, lat, hei);

    switch (p_type) {
    case "Balloon":
      aircraft_id++;
      return (new Balloon(aircraft_id, p_name, p_coordinates));

    case "Helicopter":
      aircraft_id++;
      return (new Helicopter(aircraft_id, p_name, p_coordinates));

    case "JetPlane":
      aircraft_id++;
      return (new JetPlane(aircraft_id, p_name, p_coordinates));

    default:
      throw new UnknownFlyableException("Unknown Flyable, skipping creation");
    }
  }
}
