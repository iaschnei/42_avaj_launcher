package Flyable;

public class NoTowerException extends Exception {

  public NoTowerException() {
  }

  public NoTowerException(String err_message) {
    super(err_message);
  }
}
