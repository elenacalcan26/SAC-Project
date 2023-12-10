package commands;

import com.github.rvesse.airline.annotations.Option;
import com.github.rvesse.airline.annotations.restrictions.Required;

public class InteractionCommonCommandOptions {
  @Required
  @Option(
      name = "--movieId",
      description = "Id of the movie to interact with")
  String movieId;
}
