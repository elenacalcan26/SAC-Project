package commands;

import com.github.rvesse.airline.annotations.Command;

import javax.inject.Inject;

@Command(
    name = "view",
    description = "View item user action"
)
public class ViewItemCommand implements Runnable {

  @Inject CommonCommandOptions commonOptions;

  @Inject InteractionCommonCommandOptions interactionCommonOption;

  @Override
  public void run() {
    System.out.println("View command!");
  }
}
