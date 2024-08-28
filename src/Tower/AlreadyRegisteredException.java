package Tower;

public class AlreadyRegisteredException extends Exception {

  public AlreadyRegisteredException() {
  }

  public AlreadyRegisteredException(String err_message) {
    super(err_message);
  }
}
