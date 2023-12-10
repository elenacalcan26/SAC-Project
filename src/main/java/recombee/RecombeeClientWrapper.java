package recombee;

import com.google.common.collect.ImmutableMap;
import com.recombee.api_client.RecombeeClient;
import com.recombee.api_client.api_requests.AddDetailView;
import com.recombee.api_client.api_requests.RecommendItemsToItem;
import com.recombee.api_client.api_requests.RecommendItemsToUser;
import com.recombee.api_client.api_requests.SetUserValues;
import com.recombee.api_client.bindings.Recommendation;
import com.recombee.api_client.bindings.RecommendationResponse;
import com.recombee.api_client.exceptions.ApiException;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class RecombeeClientWrapper {
  private static String DB_NAME = "acs-sac-dev";
  private static String PRIVATE_TOKEN = "qBvPhSEUkpkAt4GkFsxyeeG58QSjmD6gbrpfICSPyaY3ryRGfHHHfcEvczxsuCH9";

  private RecombeeClient client;

  private static RecombeeClientWrapper clientWrapperObject;
  private Logger logger = Logger.getLogger(RecombeeClientWrapper.class.getName());

  private RecombeeClientWrapper() {
    client = new RecombeeClient(DB_NAME, PRIVATE_TOKEN);
  }

  public static RecombeeClientWrapper getInstance() {
    if (clientWrapperObject == null) {
      clientWrapperObject = new RecombeeClientWrapper();
    }
    return clientWrapperObject;
  }

  public void registerUserRecombee(String userId, List<String> genres) throws ApiException {
    logger.info("Register user = " + userId + " with preferred genres: " + genres + " in Recombee System");
    Map<String, Object> userFavoriteGenresProperty = ImmutableMap.of(
        "favoriteGenres", new HashSet<>(genres));

    client.send(new SetUserValues(userId, userFavoriteGenresProperty)
        .setCascadeCreate(true));

    logger.info("Register done!");
  }

  public void recommendMoviesToUser(String userId) throws ApiException {
    logger.info("Recommending movies to user with id = " + userId);
    RecommendationResponse recommendations = client.send(
        new RecommendItemsToUser(userId, 10)
            .setReturnProperties(true));

    logger.info("These are your recommendation!");
    recommendations.forEach(this::printMovieRecommendation);
  }

  public void viewMovieItem(String userId, String itemId) throws ApiException {
    logger.info("User " + userId + " views movie with id = " + itemId);

    client.send(new AddDetailView(userId, itemId)
        .setCascadeCreate(true));

    logger.info("Action added to Recombee System!");
  }

  public void showSimilarMoviesToTheViewedMovie(String userId, String movieId) throws ApiException {
    logger.info("Showing similar movies to movie = " + movieId + " to user " + userId);

    RecommendationResponse response = client.send(new RecommendItemsToItem(movieId, userId, 5)
        .setCascadeCreate(true)
        .setReturnProperties(true));

    logger.info("You may also like to view:");
    response.forEach(this::printMovieRecommendation);
  }

  private void printMovieRecommendation(Recommendation recommendation) {
    Map<String, Object> movieData = recommendation.getValues();
    System.out.print("id = " + recommendation.getId() + " | ");
    System.out.print("Title = " + movieData.get("title") + " | ");
    System.out.print("Genres = " + movieData.get("genre") + " | ");
    System.out.println("Actors = " + movieData.get("actors"));
  }
}
