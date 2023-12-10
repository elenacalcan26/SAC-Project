package commands;

import com.github.rvesse.airline.annotations.Command;
import com.recombee.api_client.exceptions.ApiException;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import recombee.RecombeeClientWrapper;

import javax.inject.Inject;

@Command(
    name = "view",
    description = "View item user action"
)
public class ViewItemCommand implements Runnable {

  @Inject CommonCommandOptions commonOptions;

  @Inject InteractionCommonCommandOptions interactionCommonOption;

  private RecombeeClientWrapper clientWrapper = RecombeeClientWrapper.getInstance();

  @Override
  public void run() {
    try {
      viewInteraction();
    } catch (ApiException e) {
      throw new RuntimeException(e);
    }
  }

  private void viewInteraction() throws ApiException {
    String userId = commonOptions.userId;
    String movieId = interactionCommonOption.movieId;

    clientWrapper.viewMovieItem(userId, movieId);
    clientWrapper.showSimilarMoviesToTheViewedMovie(userId, movieId);
  }
}
