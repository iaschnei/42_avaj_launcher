package Tower;

import Flyable.Flyable;
import java.util.List;

public class Tower {

  private List<Flyable> observers;

  public void register(Flyable p_flyable) throws AlreadyRegisteredException {

    if (observers.contains(p_flyable)) {
      throw new AlreadyRegisteredException(
          "This flyable is already registered to the tower, skipping it");
    }

    observers.add(p_flyable);

    // TODO add a message using the flyable's name
  }

  public void unregister(Flyable p_flyable) throws UnregisteredException {

    if (observers.contains(p_flyable) == false) {
      throw new UnregisteredException(
          "This flyable is not registered to the tower and cannot unregister");
    }

    observers.remove(p_flyable);
  }

  protected void conditionChanged() {
  }

  protected List<Flyable> getObservers() {
    return (this.observers);
  }
}
