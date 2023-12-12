package commands;

import com.github.rvesse.airline.annotations.Command;
import com.recombee.api_client.exceptions.ApiException;
import recombee.RecombeeClientWrapper;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Command(
    name = "recommend",
    description = "Recommend movies for the user with the given userId as parameter"
)
public class ItemsRecommendationCommand implements Runnable {

  @Inject
  private CommonCommandOptions commonOptions;

  @Inject
  private InteractionCommonCommandOptions interactionCommonCommandOptions;

  private RecombeeClientWrapper clientWrapper = RecombeeClientWrapper.getInstance();

  @Override
  public void run() {
    String userId = commonOptions.userId;

    String actors = null;
    if (interactionCommonCommandOptions != null) {
      actors = String.join(" ", interactionCommonCommandOptions.actors);
    }

    try {
      if (actors != null)
      clientWrapper.recommendMoviesToUserActorPreference(userId, new ArrayList<>(Collections.singleton(actors)));
      else
        clientWrapper.recommendMoviesToUser(userId);
    } catch (ApiException e) {
      throw new RuntimeException(e);
    }
  }
}
