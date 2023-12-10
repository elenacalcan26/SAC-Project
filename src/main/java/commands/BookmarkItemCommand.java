package commands;

import com.github.rvesse.airline.annotations.Command;

import javax.inject.Inject;

@Command(
    name = "bookmark",
    description = "Bookmark item user action"
)
public class BookmarkItemCommand implements Runnable {
  @Inject
  CommonCommandOptions commonOptions;

  @Inject
  InteractionCommonCommandOptions interactionCommonOptions;

  @Override
  public void run() {
    System.out.println("Bookmark command!");
  }
}
