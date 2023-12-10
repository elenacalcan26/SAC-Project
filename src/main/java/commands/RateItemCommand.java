package commands;

import com.github.rvesse.airline.annotations.Command;

import javax.inject.Inject;

@Command(
    name = "rate",
    description = "Rate item user action"
)
public class RateItemCommand implements Runnable {
  @Inject CommonCommandOptions commonOptions;

  @Inject InteractionCommonCommandOptions interactionCommonOptions;

  @Override
  public void run() {
    System.out.println("Rate Item");
  }
}
