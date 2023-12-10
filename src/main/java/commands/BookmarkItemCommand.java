package commands;

import com.github.rvesse.airline.annotations.Command;
import com.recombee.api_client.exceptions.ApiException;
import recombee.RecombeeClientWrapper;

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

  private RecombeeClientWrapper clientWrapper = RecombeeClientWrapper.getInstance();

  @Override
  public void run() {
    String userId = commonOptions.userId;
    String movieId = interactionCommonOptions.movieId;

    try {
      clientWrapper.bookmarkMovie(userId, movieId);
    } catch (ApiException e) {
      throw new RuntimeException(e);
    }
  }
}
