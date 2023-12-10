package commands;

import com.github.rvesse.airline.annotations.Command;
import com.github.rvesse.airline.annotations.Option;
import com.github.rvesse.airline.annotations.restrictions.Required;
import com.recombee.api_client.exceptions.ApiException;
import recombee.RecombeeClientWrapper;

import javax.inject.Inject;

@Command(
    name = "rate",
    description = "Rate item user action"
)
public class RateItemCommand implements Runnable {
  @Inject CommonCommandOptions commonOptions;

  @Inject InteractionCommonCommandOptions interactionCommonOptions;

  @Required
  @Option(name = "--rate", description = "The given rating for the given movie")
  Double givenRating;

  private RecombeeClientWrapper clientWrapper = RecombeeClientWrapper.getInstance();

  @Override
  public void run() {
    String userId = commonOptions.userId;
    String movieId = interactionCommonOptions.movieId;

    try {
      clientWrapper.rateMovie(userId, movieId, givenRating);
    } catch (ApiException e) {
      throw new RuntimeException(e);
    }
  }
}
