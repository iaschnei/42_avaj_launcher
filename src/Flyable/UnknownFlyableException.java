package Flyable;

public class UnknownFlyableException extends Exception {

  public UnknownFlyableException() {
  }

  public UnknownFlyableException(String err_message) {
    super(err_message);
  }
}
