package commands;

import com.github.rvesse.airline.annotations.Command;
import com.recombee.api_client.exceptions.ApiException;
import recombee.RecombeeClientWrapper;

import javax.inject.Inject;
import java.util.Arrays;
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

    List<String> actors = null;
    if (interactionCommonCommandOptions != null) {
      System.out.println(interactionCommonCommandOptions.actors);
      actors = Arrays.stream(interactionCommonCommandOptions.actors.split(","))
              .map(String::trim)
              .collect(Collectors.toList());

      System.out.println("Actors: " + actors);
    }

    try {
      if (actors != null)
      clientWrapper.recommendMoviesToUserActorPreference(userId, actors);
      else
        clientWrapper.recommendMoviesToUser(userId);
    } catch (ApiException e) {
      throw new RuntimeException(e);
    }
  }
}
