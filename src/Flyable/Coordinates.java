package Flyable;

public class Coordinates {

  private int longitude;
  private int latitude;
  private int height;

  Coordinates(int p_longitude, int p_latitude, int p_height) {
    this.longitude = p_longitude;
    this.latitude = p_latitude;
    this.height = p_height;
  }

  public int getLongitude() {
    return (longitude);
  }

  public int getLatitude() {
    return (latitude);
  }

  public int getHeight() {
    return (height);
  }

  public int setLongitude(int newLongitude) {
    longitude = newLongitude;
    return (longitude);
  }

  public int setLatitude(int newLatitude) {
    latitude = newLatitude;
    return (latitude);
  }

  public int setHeight(int newHeight) {
    if (newHeight > 100)
      newHeight = 100;
    if (newHeight < 0)
      newHeight = 0;
    height = newHeight;
    return (height);
  }
}
