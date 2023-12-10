package commands;

import com.github.rvesse.airline.annotations.Command;
import com.recombee.api_client.exceptions.ApiException;
import recombee.RecombeeClientWrapper;

import javax.inject.Inject;

@Command(
    name = "recommend",
    description = "Recommend movies for the user with the given userId as parameter"
)
public class ItemsRecommendationCommand implements Runnable {

  @Inject
  private CommonCommandOptions commonOptions;

  private RecombeeClientWrapper clientWrapper = RecombeeClientWrapper.getInstance();

  @Override
  public void run() {
    String userId = commonOptions.userId;
    try {
      clientWrapper.recommendMoviesToUser(userId);
    } catch (ApiException e) {
      throw new RuntimeException(e);
    }
  }
}
