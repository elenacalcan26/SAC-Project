package commands;

import com.github.rvesse.airline.annotations.Option;
import com.github.rvesse.airline.annotations.restrictions.Required;

import java.util.List;

public class InteractionCommonCommandOptions {

  @Option(
      name = "--movieId",
      description = "Id of the movie to interact with")
  String movieId;

  @Option(
          name = "--actors",
          description = "List of actors to star in the movie",
          arity = 2)
  List<String> actors;
}
