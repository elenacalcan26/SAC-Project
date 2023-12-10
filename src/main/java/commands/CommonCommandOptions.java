package commands;

import com.github.rvesse.airline.annotations.Option;
import com.github.rvesse.airline.annotations.restrictions.Required;

public class CommonCommandOptions {
  @Required
  @Option(name = "--userId", description = "The user id registered in Recombee")
  String userId;
}
