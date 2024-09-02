package Tower;

import Flyable.Flyable;
import Flyable.NoTowerException;
import java.util.ArrayList;
import java.util.List;

public class Tower {

  private List<Flyable> observers = new ArrayList<Flyable>();

  public void register(Flyable p_flyable) throws AlreadyRegisteredException {

    if (observers.contains(p_flyable)) {
      throw new AlreadyRegisteredException(
          "This flyable is already registered to the tower, skipping it");
    }

    observers.add(p_flyable);

    p_flyable.registerTower((WeatherTower)this);

    System.out.println(p_flyable.getName() + " is registered to the tower.");
  }

  public void unregister(Flyable p_flyable) throws UnregisteredException {

    if (observers.contains(p_flyable) == false) {
      throw new UnregisteredException(
          "This flyable is not registered to the tower and cannot unregister");
    }

    observers.remove(p_flyable);

    p_flyable.registerTower(null);

    System.out.println(p_flyable.getName() +
                       " has been unregistered from the tower.");
  }

  protected void conditionChanged()
      throws NoTowerException, UnregisteredException {

    for (int i = 0; i < observers.size(); i++) {
      observers.get(i).updateConditions();
    }
  }

  protected List<Flyable> getObservers() { return (this.observers); }
}
